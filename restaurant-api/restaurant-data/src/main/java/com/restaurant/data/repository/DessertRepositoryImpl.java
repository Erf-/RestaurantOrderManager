package com.restaurant.data.repository;

import com.restaurant.domain.repository.DessertRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class DessertRepositoryImpl implements DessertRepository {

    private final ConcurrentMap<String, Integer> dessertStore = new ConcurrentHashMap<>();

    @Override
    public boolean isAvailable(String name) {
        return Optional.ofNullable(dessertStore.get(name)).orElse(0) > 0;
    }

    @Override
    public void decrement(String name) {
        dessertStore.computeIfPresent(name, (k, v) -> --v);
    }
}
