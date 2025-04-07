package com.restaurant.domain.model;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class Cook {

    private final ExecutorService executorService;

    public CompletableFuture<Meal> prepare(Meal meal) {
        CompletableFuture<Meal> completableFuture = new CompletableFuture<>();

        executorService.submit(() -> {
            Thread.sleep(500);
            completableFuture.complete(meal);
            return null;
        });

        return completableFuture;
    }
}
