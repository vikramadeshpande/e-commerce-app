package com.ecommerce.order_service.service;

import com.ecommerce.order_service.customer.client.CustomerClient;
import com.ecommerce.order_service.exception.BusinessException;
import com.ecommerce.order_service.kafka.OrderConfirmation;
import com.ecommerce.order_service.kafka.OrderProducer;
import com.ecommerce.order_service.mapper.OrderMapper;
import com.ecommerce.order_service.orderline.request.OrderLineRequest;
import com.ecommerce.order_service.orderline.service.OrderLineService;
import com.ecommerce.order_service.payment.PaymentClient;
import com.ecommerce.order_service.payment.request.PaymentRequest;
import com.ecommerce.order_service.product.client.ProductClient;
import com.ecommerce.order_service.product.request.PurchaseRequest;
import com.ecommerce.order_service.repository.OrderRepository;
import com.ecommerce.order_service.request.OrderRequest;
import com.ecommerce.order_service.response.OrderResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerClient customerClient;
    private final PaymentClient paymentClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    @Transactional
    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));

        var purchasedProducts = productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAllOrders() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(this.mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }
}