package com.restaurant.rest.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.restaurant.data",
    "com.restaurant.service",
    "com.restaurant.rest.presentation",
    "com.restaurant.rest.spring"
})
public class ApplicationConfig {
    // Empty configuration for now
}
