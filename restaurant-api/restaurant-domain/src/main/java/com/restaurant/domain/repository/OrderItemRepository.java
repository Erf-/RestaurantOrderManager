package com.restaurant.domain.repository;

public interface OrderItemRepository {

    boolean isAvailable(String name);
    void decrement(String name);
}
