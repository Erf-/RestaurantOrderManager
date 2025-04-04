package com.restaurant.data.repository;

import com.restaurant.domain.model.Food;
import com.restaurant.domain.repository.FoodRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Implementation of the FoodRepository interface.
 */
@Repository
public class FoodRepositoryImpl implements FoodRepository {
    
    private final ConcurrentMap<String, Food> foodStore = new ConcurrentHashMap<>();

    @Override
    public Optional<Food> findById(String id) {
        return Optional.ofNullable(foodStore.get(id));
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(foodStore.values());
    }

    @Override
    public Food save(Food food) {
        foodStore.put(food.getId(), food);
        return food;
    }
}
