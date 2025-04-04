package com.restaurant.rest.spring.config;

import com.restaurant.rest.presentation.mapper.OrderMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the application.
 */
@Configuration
public class AppConfig {

    /**
     * Bean for the OrderMapper
     * 
     * @return the OrderMapper instance
     */
    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper();
    }
}
