package com.restaurant.rest.spring.controller;

import com.restaurant.domain.model.Order;
import com.restaurant.rest.presentation.dto.OrderDto;
import com.restaurant.rest.presentation.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(orderMapper.toOrderDto(createdOrder), HttpStatus.CREATED);
    }
}
