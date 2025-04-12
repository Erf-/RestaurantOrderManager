package com.restaurant.data.repository;

import com.restaurant.domain.repository.MealRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class MealRepositoryImpl implements MealRepository {
    
    private final ConcurrentMap<String, Integer> stocks = new ConcurrentHashMap<>();

    @Override
    public boolean isAvailable(String name) {
        return Optional.ofNullable(stocks.get(name)).orElse(0) > 0;
    }

    @Override
    public void decrement(String name) {
        stocks.computeIfPresent(name, (k, v) -> --v);
    }
}
