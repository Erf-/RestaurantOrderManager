package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Order;
import com.restaurant.rest.presentation.dto.OrderDto;

public interface OrderMapper {
    Order toOrder(OrderDto orderDto);
    OrderDto toOrderDto(Order order);
}
