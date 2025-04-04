package com.restaurant.domain.repository;

import com.restaurant.domain.model.Dessert;
import java.util.List;
import java.util.Optional;

public interface DessertRepository {
    Optional<Dessert> findById(String id);
    List<Dessert> findAll();
    Dessert save(Dessert dessert);
}
