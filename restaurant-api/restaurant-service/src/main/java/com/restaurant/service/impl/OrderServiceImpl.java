package com.restaurant.service.impl;

import com.restaurant.domain.model.Order;
import com.restaurant.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Order order) {
        // Empty implementation for now
        return order;
    }
}
