package com.restaurant.data.repository;

import com.restaurant.domain.repository.DrinkRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class DrinkRepositoryImpl implements DrinkRepository {

    private final ConcurrentMap<String, Integer> drinkStore = new ConcurrentHashMap<>();

    @Override
    public boolean isAvailable(String name) {
        return Optional.ofNullable(drinkStore.get(name)).orElse(0) > 0;
    }

    @Override
    public void decrement(String name) {
        drinkStore.computeIfPresent(name, (k, v) -> --v);
    }
}
