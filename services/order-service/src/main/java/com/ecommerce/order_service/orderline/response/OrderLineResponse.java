package com.ecommerce.order_service.orderline.response;


public record OrderLineResponse(
        Integer id,
        double quantity
) { }
