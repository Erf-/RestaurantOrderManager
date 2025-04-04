package com.restaurant.rest.spring.controller;

import com.restaurant.rest.presentation.dto.OrderDTO;
import com.restaurant.rest.presentation.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing orders.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    /**
     * POST /orders : Create a new order
     *
     * @param orderDTO the order to create
     * @return the ResponseEntity with status 201 (Created) and with body the new order
     */
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        // Convert DTO to domain object
        var order = orderMapper.toDomain(orderDTO);
        
        // Process the order with service
        var createdOrder = orderService.createOrder(order);
        
        // Convert back to DTO
        var createdOrderDTO = orderMapper.toDTO(createdOrder);
        
        return new ResponseEntity<>(createdOrderDTO, HttpStatus.CREATED);
    }
}
