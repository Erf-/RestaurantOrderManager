package com.restaurant.rest.presentation.dto;

import java.util.List;

public record OrderDTO(List<DrinkDTO> drinks, List<MealDTO> meals, List<DessertDTO> desserts) {

}
