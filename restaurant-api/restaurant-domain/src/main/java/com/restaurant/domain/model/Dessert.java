package com.restaurant.domain.model;

import com.restaurant.domain.repository.DessertRepository;

public class Dessert extends OrderItem {

    public Dessert(String name, DessertRepository repository) {
        super(name, repository);
    }
}
