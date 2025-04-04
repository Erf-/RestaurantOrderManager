package com.restaurant.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String id;
    private LocalDateTime orderTime;
    private Waiter waiter;
    private List<Food> foodItems;
    private List<Drink> drinkItems;
    private List<Dessert> dessertItems;
    private String status;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    
    public Waiter getWaiter() {
        return waiter;
    }
    
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
    
    public List<Food> getFoodItems() {
        return foodItems;
    }
    
    public void setFoodItems(List<Food> foodItems) {
        this.foodItems = foodItems;
    }
    
    public List<Drink> getDrinkItems() {
        return drinkItems;
    }
    
    public void setDrinkItems(List<Drink> drinkItems) {
        this.drinkItems = drinkItems;
    }
    
    public List<Dessert> getDessertItems() {
        return dessertItems;
    }
    
    public void setDessertItems(List<Dessert> dessertItems) {
        this.dessertItems = dessertItems;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
