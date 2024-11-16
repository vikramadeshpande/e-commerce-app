package com.ecommerce.payment_service.request;

import com.ecommerce.payment_service.dto.Customer;
import com.ecommerce.payment_service.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
