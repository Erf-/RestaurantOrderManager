package com.restaurant.domain.model;

import com.restaurant.domain.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Drink implements OrderItem {
    private final String name;
    private final DrinkRepository repository;

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return repository.isAvailable(name);
    }
}
