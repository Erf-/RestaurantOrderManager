package com.restaurant.domain.repository;

import com.restaurant.domain.model.Drink;
import java.util.List;
import java.util.Optional;

public interface DrinkRepository {
    Optional<Drink> findById(String id);
    List<Drink> findAll();
    Drink save(Drink drink);
}
