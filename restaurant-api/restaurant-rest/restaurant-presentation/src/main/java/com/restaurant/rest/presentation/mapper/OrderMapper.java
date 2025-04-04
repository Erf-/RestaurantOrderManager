package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Dessert;
import com.restaurant.domain.model.Drink;
import com.restaurant.domain.model.Food;
import com.restaurant.domain.model.Order;
import com.restaurant.domain.model.Waiter;
import com.restaurant.rest.presentation.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for the Order entity and DTO.
 */
public class OrderMapper {

    /**
     * Convert a domain Order object to an OrderDTO
     * 
     * @param order the domain Order object
     * @return the OrderDTO
     */
    public OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }

        List<String> foodIds = order.getFoodItems() != null 
            ? order.getFoodItems().stream().map(Food::getId).collect(Collectors.toList())
            : new ArrayList<>();

        List<String> drinkIds = order.getDrinkItems() != null 
            ? order.getDrinkItems().stream().map(Drink::getId).collect(Collectors.toList())
            : new ArrayList<>();

        List<String> dessertIds = order.getDessertItems() != null 
            ? order.getDessertItems().stream().map(Dessert::getId).collect(Collectors.toList())
            : new ArrayList<>();

        return new OrderDTO(
            order.getId(),
            order.getOrderTime(),
            order.getWaiter() != null ? order.getWaiter().getId() : null,
            foodIds,
            drinkIds,
            dessertIds,
            order.getStatus()
        );
    }

    /**
     * Convert an OrderDTO to a domain Order object
     * Note: This method creates a partial Order object with just IDs rather than full objects.
     * The service layer would need to fetch the complete objects.
     * 
     * @param orderDTO the OrderDTO
     * @return the domain Order object
     */
    public Order toDomain(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        // Create a waiter with just the ID
        Waiter waiter = new Waiter();
        waiter.setId(orderDTO.getWaiterId());

        // Create food items with just the IDs
        List<Food> foodItems = orderDTO.getFoodIds() != null
            ? orderDTO.getFoodIds().stream().map(id -> {
                Food food = new Food();
                food.setId(id);
                return food;
              }).collect(Collectors.toList())
            : new ArrayList<>();

        // Create drink items with just the IDs
        List<Drink> drinkItems = orderDTO.getDrinkIds() != null
            ? orderDTO.getDrinkIds().stream().map(id -> {
                Drink drink = new Drink();
                drink.setId(id);
                return drink;
              }).collect(Collectors.toList())
            : new ArrayList<>();

        // Create dessert items with just the IDs
        List<Dessert> dessertItems = orderDTO.getDessertIds() != null
            ? orderDTO.getDessertIds().stream().map(id -> {
                Dessert dessert = new Dessert();
                dessert.setId(id);
                return dessert;
              }).collect(Collectors.toList())
            : new ArrayList<>();

        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setWaiter(waiter);
        order.setFoodItems(foodItems);
        order.setDrinkItems(drinkItems);
        order.setDessertItems(dessertItems);
        order.setStatus(orderDTO.getStatus());

        return order;
    }
}
