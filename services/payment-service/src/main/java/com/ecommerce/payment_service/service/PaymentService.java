package com.ecommerce.payment_service.service;

import com.ecommerce.payment_service.mapper.PaymentMapper;
import com.ecommerce.payment_service.notification.NotificationProducer;
import com.ecommerce.payment_service.notification.PaymentNotificationRequest;
import com.ecommerce.payment_service.repository.PaymentRepository;
import com.ecommerce.payment_service.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
