package com.restaurant.domain.model;

import java.util.List;
import java.util.Optional;

public record Order(Optional<List<Drink>> drinks, Optional<List<Meal>> meals, Optional<List<Dessert>> desserts) {

}
