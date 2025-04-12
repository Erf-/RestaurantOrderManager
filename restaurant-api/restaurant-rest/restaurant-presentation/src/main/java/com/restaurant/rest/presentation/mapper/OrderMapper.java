package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Order;
import com.restaurant.rest.presentation.dto.OrderDTO;

import java.util.Optional;

public final class OrderMapper {

    private final DrinkMapper drinkMapper;
    private final MealMapper mealMapper;
    private final DessertMapper dessertMapper;

    public OrderMapper(DrinkMapper drinkMapper, MealMapper mealMapper, DessertMapper dessertMapper) {
        this.drinkMapper = drinkMapper;
        this.mealMapper = mealMapper;
        this.dessertMapper = dessertMapper;
    }

    public Order toDomain(OrderDTO orderDTO) {
        return new Order(
                Optional.ofNullable(orderDTO.drinks()).map(drinkMapper::toDomain),
                Optional.ofNullable(orderDTO.meals()).map(mealMapper::toDomain),
                Optional.ofNullable(orderDTO.desserts()).map(dessertMapper::toDomain));
    }
    
    public OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.drinks().map(drinkMapper::toDTO).orElse(null),
                order.meals().map(mealMapper::toDTO).orElse(null),
                order.desserts().map(dessertMapper::toDTO).orElse(null));
    }
}
