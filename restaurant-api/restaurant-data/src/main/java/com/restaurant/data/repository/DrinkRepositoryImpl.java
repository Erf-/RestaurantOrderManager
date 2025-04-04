package com.restaurant.data.repository;

import com.restaurant.domain.model.Drink;
import com.restaurant.domain.repository.DrinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Implementation of the DrinkRepository interface.
 */
@Repository
public class DrinkRepositoryImpl implements DrinkRepository {

    private final ConcurrentMap<String, Drink> drinkStore = new ConcurrentHashMap<>();
    
    @Override
    public Optional<Drink> findById(String id) {
        return Optional.ofNullable(drinkStore.get(id));
    }

    @Override
    public List<Drink> findAll() {
        return new ArrayList<>(drinkStore.values());
    }

    @Override
    public Drink save(Drink drink) {
        drinkStore.put(drink.getId(), drink);
        return drink;
    }
}
