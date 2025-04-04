package com.restaurant.service;

import com.restaurant.domain.model.Order;

/**
 * Service interface for managing orders.
 */
public interface OrderService {
    
    /**
     * Create a new order
     * 
     * @param order the order to create
     * @return the created order
     */
    Order createOrder(Order order);
}
