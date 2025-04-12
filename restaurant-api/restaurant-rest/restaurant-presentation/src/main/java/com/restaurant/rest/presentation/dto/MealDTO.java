package com.restaurant.rest.presentation.dto;

public record MealDTO(String name, Boolean isAvailable) {

    public MealDTO(String name) {
        this(name, null);
    }
}
