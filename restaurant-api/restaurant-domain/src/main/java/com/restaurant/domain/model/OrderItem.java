package com.restaurant.domain.model;

import com.restaurant.domain.repository.OrderItemRepository;


public abstract class OrderItem {

    protected final String name;
    private final OrderItemRepository repository;

    protected OrderItem(String name, OrderItemRepository repository) {
        this.name = name;
        this.repository = repository;
    }

    public final String name() {
        return name;
    }

    public final boolean isAvailable() {
        return repository.isAvailable(name);
    }

    // skeleton pattern
    public final void prepare() {
        repository.decrement(name);
        doPrepare();
    }

    protected void doPrepare() {
        // do nothing by default
    }
}
