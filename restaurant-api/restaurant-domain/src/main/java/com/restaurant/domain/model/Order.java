package com.restaurant.domain.model;

import java.util.List;

public record Order(List<Drink> drinks, List<Meal> meals, List<Dessert> desserts) {

}
