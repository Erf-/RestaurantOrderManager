package com.restaurant.rest.presentation.dto;

public record DessertDTO(String name, Boolean isAvailable) {

    public DessertDTO(String name) {
        this(name, null);
    }
}
