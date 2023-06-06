package com.mapping.Mapping.service;

import com.mapping.Mapping.entities.Orders;
import com.mapping.Mapping.request.dto.OrderRequest;
import com.mapping.Mapping.response.dto.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService{
    public void safeOrder(OrderRequest orderRequest);

    public List<OrderResponse> getAllOrders();

    public boolean existsById(Long id);

    public OrderResponse getOrderById(Long id);

    public void deleteOrder(Long id);
}
