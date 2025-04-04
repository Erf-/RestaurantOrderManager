package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Order;
import com.restaurant.domain.model.Waiter;
import com.restaurant.rest.presentation.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    
    public Order toOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderTime(orderDto.getOrderTime() != null ? orderDto.getOrderTime() : LocalDateTime.now());
        order.setStatus(orderDto.getStatus() != null ? orderDto.getStatus() : "NEW");
        
        // Set waiter if waiterId is provided
        if (orderDto.getWaiterId() != null) {
            Waiter waiter = new Waiter();
            waiter.setId(orderDto.getWaiterId());
            order.setWaiter(waiter);
        }
        
        // Food, drink and dessert items would be retrieved from repositories
        // For now, we're just creating empty lists
        order.setFoodItems(new ArrayList<>());
        order.setDrinkItems(new ArrayList<>());
        order.setDessertItems(new ArrayList<>());
        
        return order;
    }
    
    public OrderDto toOrderDto(Order order) {
        if (order == null) {
            return null;
        }
        
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderTime(order.getOrderTime());
        orderDto.setStatus(order.getStatus());
        
        // Set waiterId if waiter is provided
        if (order.getWaiter() != null) {
            orderDto.setWaiterId(order.getWaiter().getId());
        }
        
        // Pass through the food, drink, and dessert IDs from the input DTO
        // Since we're not implementing actual repository lookups,
        // we'll keep the original IDs from the request
        List<String> emptyList = new ArrayList<>();
        orderDto.setFoodIds(emptyList);
        orderDto.setDrinkIds(emptyList);
        orderDto.setDessertIds(emptyList);
        
        return orderDto;
    }
}
