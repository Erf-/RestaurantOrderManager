package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Order;
import com.restaurant.rest.presentation.dto.OrderDTO;

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
                drinkMapper.toDomain(orderDTO.drinks()),
                mealMapper.toDomain(orderDTO.meals()),
                dessertMapper.toDomain(orderDTO.desserts()));
    }
    
    public OrderDTO toDTO(Order order) {
        return new OrderDTO(
                drinkMapper.toDTO(order.drinks()),
                mealMapper.toDTO(order.meals()),
                dessertMapper.toDTO(order.desserts()));
    }
}
