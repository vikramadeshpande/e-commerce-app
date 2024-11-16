package com.ecommerce.customer_service.response;

import com.ecommerce.customer_service.entity.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
