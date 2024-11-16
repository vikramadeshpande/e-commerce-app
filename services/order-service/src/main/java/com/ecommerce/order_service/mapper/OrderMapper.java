package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.entity.Order;
import com.ecommerce.order_service.request.OrderRequest;
import com.ecommerce.order_service.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {


    public Order toOrder(OrderRequest request) {
        if (request == null) {
            return null;
        }
        return Order.builder()
                .id(request.id())
                .reference(request.reference())
                .paymentMethod(request.paymentMethod())
                .customerId(request.customerId())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
