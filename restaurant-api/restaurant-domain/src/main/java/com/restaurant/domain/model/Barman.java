package com.restaurant.domain.model;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class Barman {

    private final ExecutorService executorService;

    public CompletableFuture<Drink> prepare(Drink drink) {
        CompletableFuture<Drink> completableFuture = new CompletableFuture<>();

        executorService.submit(() -> {
            Thread.sleep(500);
            completableFuture.complete(drink);
            return null;
        });

        return completableFuture;
    }
}
