package com.restaurant.rest.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private LocalDateTime orderTime;
    private String waiterId;
    private List<String> foodIds;
    private List<String> drinkIds;
    private List<String> dessertIds;
    private String status;
    
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    
    public String getWaiterId() {
        return waiterId;
    }
    
    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }
    
    public List<String> getFoodIds() {
        return foodIds;
    }
    
    public void setFoodIds(List<String> foodIds) {
        this.foodIds = foodIds;
    }
    
    public List<String> getDrinkIds() {
        return drinkIds;
    }
    
    public void setDrinkIds(List<String> drinkIds) {
        this.drinkIds = drinkIds;
    }
    
    public List<String> getDessertIds() {
        return dessertIds;
    }
    
    public void setDessertIds(List<String> dessertIds) {
        this.dessertIds = dessertIds;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
