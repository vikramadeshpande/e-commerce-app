package com.ecommerce.order_service.kafka;

import com.ecommerce.order_service.customer.response.CustomerResponse;
import com.ecommerce.order_service.product.response.PurchaseResponse;
import com.ecommerce.order_service.service.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
