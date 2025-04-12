package com.restaurant.domain.model;

import com.restaurant.domain.repository.MealRepository;

public class Meal extends OrderItem {

    public Meal(String name, MealRepository repository) {
        super(name, repository);
    }

    @Override
    protected void doPrepare() {
        System.out.println("Preparing Meal " + name);
    }
}
