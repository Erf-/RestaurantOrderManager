package com.restaurant.service.impl;

import com.restaurant.domain.model.Dessert;
import com.restaurant.domain.model.Drink;
import com.restaurant.domain.model.Food;
import com.restaurant.domain.model.Order;
import com.restaurant.domain.repository.DessertRepository;
import com.restaurant.domain.repository.DrinkRepository;
import com.restaurant.domain.repository.FoodRepository;
import com.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the OrderService interface.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final FoodRepository foodRepository;
    private final DrinkRepository drinkRepository;
    private final DessertRepository dessertRepository;

    @Autowired
    public OrderServiceImpl(
            FoodRepository foodRepository,
            DrinkRepository drinkRepository,
            DessertRepository dessertRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.dessertRepository = dessertRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // Generate an ID if one doesn't exist
        if (order.getId() == null || order.getId().isEmpty()) {
            order.setId(UUID.randomUUID().toString());
        }
        
        // Set the order time if not set
        if (order.getOrderTime() == null) {
            order.setOrderTime(LocalDateTime.now());
        }
        
        // Set initial status if not set
        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            order.setStatus("CREATED");
        }
        
        // Fetch complete Food objects from repository based on IDs
        List<Food> completeFood = new ArrayList<>();
        if (order.getFoodItems() != null) {
            for (Food food : order.getFoodItems()) {
                foodRepository.findById(food.getId())
                    .ifPresent(completeFood::add);
            }
        }
        order.setFoodItems(completeFood);
        
        // Fetch complete Drink objects from repository based on IDs
        List<Drink> completeDrink = new ArrayList<>();
        if (order.getDrinkItems() != null) {
            for (Drink drink : order.getDrinkItems()) {
                drinkRepository.findById(drink.getId())
                    .ifPresent(completeDrink::add);
            }
        }
        order.setDrinkItems(completeDrink);
        
        // Fetch complete Dessert objects from repository based on IDs
        List<Dessert> completeDessert = new ArrayList<>();
        if (order.getDessertItems() != null) {
            for (Dessert dessert : order.getDessertItems()) {
                dessertRepository.findById(dessert.getId())
                    .ifPresent(completeDessert::add);
            }
        }
        order.setDessertItems(completeDessert);
        
        // In a real application, we would save the order to a repository here
        
        return order;
    }
}
