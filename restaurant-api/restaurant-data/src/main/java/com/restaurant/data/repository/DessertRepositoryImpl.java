package com.restaurant.data.repository;

import com.restaurant.domain.model.Dessert;
import com.restaurant.domain.repository.DessertRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Implementation of the DessertRepository interface.
 */
@Repository
public class DessertRepositoryImpl implements DessertRepository {

    private final ConcurrentMap<String, Dessert> dessertStore = new ConcurrentHashMap<>();
    
    @Override
    public Optional<Dessert> findById(String id) {
        return Optional.ofNullable(dessertStore.get(id));
    }

    @Override
    public List<Dessert> findAll() {
        return new ArrayList<>(dessertStore.values());
    }

    @Override
    public Dessert save(Dessert dessert) {
        dessertStore.put(dessert.getId(), dessert);
        return dessert;
    }
}
