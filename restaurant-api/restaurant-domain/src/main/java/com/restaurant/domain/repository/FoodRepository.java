package com.restaurant.domain.repository;

import com.restaurant.domain.model.Food;
import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    Optional<Food> findById(String id);
    List<Food> findAll();
    Food save(Food food);
}
