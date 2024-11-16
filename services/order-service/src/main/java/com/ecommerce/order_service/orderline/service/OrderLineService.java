package com.ecommerce.order_service.orderline.service;

import com.ecommerce.order_service.orderline.mapper.OrderLineMapper;
import com.ecommerce.order_service.orderline.repository.OrderLineRepository;
import com.ecommerce.order_service.orderline.request.OrderLineRequest;
import com.ecommerce.order_service.orderline.response.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest request) {
        var order = mapper.toOrderLine(request);
        return repository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
