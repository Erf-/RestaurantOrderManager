package com.restaurant.service;

import com.restaurant.domain.model.Order;
import com.restaurant.domain.model.Waiter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final Waiter waiter;

    public Order createOrder(Order order) {
        return waiter.process(order);
    }
}
