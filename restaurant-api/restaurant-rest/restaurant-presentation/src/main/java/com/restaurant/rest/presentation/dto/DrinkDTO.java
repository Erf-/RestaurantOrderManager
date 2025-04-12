package com.restaurant.rest.presentation.dto;

public record DrinkDTO(String name, Boolean isAvailable) {

    public DrinkDTO(String name) {
        this(name, null);
    }
}
