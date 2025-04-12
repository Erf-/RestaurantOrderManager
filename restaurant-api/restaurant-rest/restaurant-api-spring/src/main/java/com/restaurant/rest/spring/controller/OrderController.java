package com.restaurant.rest.spring.controller;

import com.restaurant.domain.model.Order;
import com.restaurant.rest.presentation.dto.OrderDTO;
import com.restaurant.rest.presentation.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
        final Order order = orderMapper.toDomain(orderDto);
        final Order createdOrder = orderService.createOrder(order);
        final OrderDTO responseDto = orderMapper.toDTO(createdOrder);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
