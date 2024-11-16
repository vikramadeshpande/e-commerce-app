package com.ecommerce.order_service.orderline.mapper;

import com.ecommerce.order_service.entity.Order;
import com.ecommerce.order_service.orderline.entity.OrderLine;
import com.ecommerce.order_service.orderline.request.OrderLineRequest;
import com.ecommerce.order_service.orderline.response.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
