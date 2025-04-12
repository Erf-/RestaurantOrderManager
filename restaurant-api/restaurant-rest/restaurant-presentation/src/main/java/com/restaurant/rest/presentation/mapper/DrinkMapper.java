package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Drink;
import com.restaurant.domain.model.Meal;
import com.restaurant.domain.repository.DessertRepository;
import com.restaurant.domain.repository.DrinkRepository;
import com.restaurant.rest.presentation.dto.DrinkDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class DrinkMapper {

    private final DrinkRepository repository;

    public List<Drink> toDomain(List<DrinkDTO> drinks) {
        return drinks.stream()
                .map(this::toDomain)
                .toList();
    }

    public Drink toDomain(DrinkDTO drink) {
        return new Drink(drink.name(), repository);
    }

    public List<DrinkDTO> toDTO(List<Drink> drinks) {
        return drinks.stream()
                .map(this::toDTO)
                .toList();
    }

    public DrinkDTO toDTO(Drink drink) {
        return new DrinkDTO(drink.name(), drink.isAvailable());
    }
}
