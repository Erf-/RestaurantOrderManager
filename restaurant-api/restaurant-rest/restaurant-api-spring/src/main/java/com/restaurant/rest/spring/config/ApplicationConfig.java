package com.restaurant.rest.spring.config;

import com.restaurant.rest.presentation.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.restaurant.data",
    "com.restaurant.rest.spring"
})
public class ApplicationConfig {
    
    @Bean
    public OrderService orderService() {
        return new OrderService();
    }
    
    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper();
    }
}
