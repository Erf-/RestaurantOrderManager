package com.restaurant.rest.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application class for the Restaurant API.
 */
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.restaurant.rest.spring", 
    "com.restaurant.service", 
    "com.restaurant.data.repository"
})
public class RestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }
}
