package com.restaurant.domain.repository;

import com.restaurant.domain.model.Dessert;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Dessert entities
 */
public interface DessertRepository {
    
    /**
     * Find a dessert item by its id
     * 
     * @param id the dessert item id
     * @return an Optional containing the dessert item if found
     */
    Optional<Dessert> findById(String id);
    
    /**
     * Get all dessert items
     * 
     * @return list of all dessert items
     */
    List<Dessert> findAll();
    
    /**
     * Save a dessert item
     * 
     * @param dessert the dessert item to save
     * @return the saved dessert item
     */
    Dessert save(Dessert dessert);
}
