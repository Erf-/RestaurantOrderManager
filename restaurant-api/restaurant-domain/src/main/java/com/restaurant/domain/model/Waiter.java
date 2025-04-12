package com.restaurant.domain.model;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class Waiter {

    private final Cook cook;
    private final Barman barman;

    public Order process(Order order) {
        boolean isEveryItemAvailable = isEveryItemAvailable(order);

        if (isEveryItemAvailable) {
            order.meals().ifPresent(meals -> meals.forEach(meal -> cook.prepare(meal).thenAccept(this::serve)));
            order.drinks().ifPresent(drinks -> drinks.forEach(drink -> barman.prepare(drink).thenAccept(this::serve)));
            order.desserts().ifPresent(desserts -> desserts.forEach(this::serve));
        }

        return order;
    }

    private boolean isEveryItemAvailable(Order order) {
        return order.drinks().stream().flatMap(Collection::stream).allMatch(Drink::isAvailable) &&
                order.meals().stream().flatMap(Collection::stream).allMatch(Meal::isAvailable) &&
                order.desserts().stream().flatMap(Collection::stream).allMatch(Dessert::isAvailable);
    }

    private void serve(OrderItem item) {
        if (item instanceof Dessert) {
            item.prepare();
        }

        System.out.println(item.name() + " served!");
    }
}
