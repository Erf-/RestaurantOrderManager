package com.restaurant.domain.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Waiter {

    private final Cook cook;
    private final Barman barman;

    public Order process(Order order) {
        boolean isEveryItemAvailable = isEveryItemAvailable(order);

        if (isEveryItemAvailable) {
            order.meals().forEach(meal -> cook.prepare(meal).thenAccept(this::serve));
            order.drinks().forEach(drink -> barman.prepare(drink).thenAccept(this::serve));
            order.desserts().forEach(this::serve);
        }

        return order;
    }

    private boolean isEveryItemAvailable(Order order) {
        return order.drinks().stream().allMatch(Drink::isAvailable) &&
                order.meals().stream().allMatch(Meal::isAvailable) &&
                order.desserts().stream().allMatch(Dessert::isAvailable);
    }

    private void serve(OrderItem item) {
        System.out.println(item.name() + " served!");
    }
}
