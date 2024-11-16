package com.ecommerce.order_service.customer.response;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {

}
