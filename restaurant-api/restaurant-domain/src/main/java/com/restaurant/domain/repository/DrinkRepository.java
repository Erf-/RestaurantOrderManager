package com.restaurant.domain.repository;

import com.restaurant.domain.model.Drink;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Drink entities
 */
public interface DrinkRepository {
    
    /**
     * Find a drink item by its id
     * 
     * @param id the drink item id
     * @return an Optional containing the drink item if found
     */
    Optional<Drink> findById(String id);
    
    /**
     * Get all drink items
     * 
     * @return list of all drink items
     */
    List<Drink> findAll();
    
    /**
     * Save a drink item
     * 
     * @param drink the drink item to save
     * @return the saved drink item
     */
    Drink save(Drink drink);
}
