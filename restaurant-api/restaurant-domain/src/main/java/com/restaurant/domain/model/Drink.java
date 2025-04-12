package com.restaurant.domain.model;

import com.restaurant.domain.repository.DrinkRepository;

public class Drink extends OrderItem {

    public Drink(String name, DrinkRepository repository) {
        super(name, repository);
    }

    @Override
    protected void doPrepare() {
        System.out.println("Preparing Drink " + name);
    }
}
