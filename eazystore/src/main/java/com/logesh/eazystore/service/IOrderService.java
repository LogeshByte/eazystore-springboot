package com.logesh.eazystore.service;

import com.logesh.eazystore.dto.OrderRequestDto;
import com.logesh.eazystore.dto.OrderResponseDto;
import com.logesh.eazystore.entity.Order;

import java.util.List;

public interface IOrderService {

    void createOrder(OrderRequestDto orderRequest);

    List<OrderResponseDto> getCustomerOrders();

    List<OrderResponseDto> getAllPendingOrders();

    void updateOrderStatus(Long orderId, String orderStatus);
}
