package com.restaurant.domain.repository;

import com.restaurant.domain.model.Food;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Food entities
 */
public interface FoodRepository {
    
    /**
     * Find a food item by its id
     * 
     * @param id the food item id
     * @return an Optional containing the food item if found
     */
    Optional<Food> findById(String id);
    
    /**
     * Get all food items
     * 
     * @return list of all food items
     */
    List<Food> findAll();
    
    /**
     * Save a food item
     * 
     * @param food the food item to save
     * @return the saved food item
     */
    Food save(Food food);
}
