package com.restaurant.rest.spring.config;

import com.restaurant.domain.model.Barman;
import com.restaurant.domain.model.Cook;
import com.restaurant.domain.model.Waiter;
import com.restaurant.domain.repository.DessertRepository;
import com.restaurant.domain.repository.DrinkRepository;
import com.restaurant.domain.repository.MealRepository;
import com.restaurant.rest.presentation.mapper.DessertMapper;
import com.restaurant.rest.presentation.mapper.DrinkMapper;
import com.restaurant.rest.presentation.mapper.MealMapper;
import com.restaurant.rest.presentation.mapper.OrderMapper;
import com.restaurant.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan(basePackages = {
    "com.restaurant.data",
    "com.restaurant.rest.spring"
})
public class ApplicationConfig {
    
    @Bean
    public OrderService orderService(Waiter waiter) {
        return new OrderService(waiter);
    }

    @Bean
    public Waiter waiter(Cook cook, Barman barman) {
        return new Waiter(cook, barman);
    }

    @Bean
    public Cook cook(ExecutorService executorService) {
        return new Cook(executorService);
    }

    @Bean
    public Barman barman(ExecutorService executorService) {
        return new Barman(executorService);
    }

    @Bean ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

    @Bean
    public OrderMapper orderMapper(DrinkMapper drinkMapper, MealMapper mealMapper, DessertMapper dessertMapper) {
        return new OrderMapper(drinkMapper, mealMapper, dessertMapper);
    }

    @Bean
    public DrinkMapper drinkMapper(DrinkRepository drinkRepository) {
        return new DrinkMapper(drinkRepository);
    }

    @Bean
    public MealMapper mealMapper(MealRepository mealRepository) {
        return new MealMapper(mealRepository);
    }

    @Bean
    public DessertMapper dessertMapper(DessertRepository dessertRepository) {
        return new DessertMapper(dessertRepository);
    }
}
