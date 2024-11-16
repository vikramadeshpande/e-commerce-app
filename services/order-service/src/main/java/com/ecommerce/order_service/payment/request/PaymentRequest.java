package com.ecommerce.order_service.payment.request;

import com.ecommerce.order_service.customer.response.CustomerResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        com.ecommerce.order_service.service.PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
