package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Meal;
import com.restaurant.domain.repository.MealRepository;
import com.restaurant.rest.presentation.dto.MealDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MealMapper {

    private final MealRepository repository;

    public List<Meal> toDomain(List<MealDTO> meals) {
        return meals.stream()
                .map(this::toDomain)
                .toList();
    }

    public Meal toDomain(MealDTO meal) {
        return new Meal(meal.name(), repository);
    }

    public List<MealDTO> toDTO(List<Meal> meals) {
        return meals.stream()
                .map(this::toDTO)
                .toList();
    }

    public MealDTO toDTO(Meal meal) {
        return new MealDTO(meal.name(), meal.isAvailable());
    }
}
