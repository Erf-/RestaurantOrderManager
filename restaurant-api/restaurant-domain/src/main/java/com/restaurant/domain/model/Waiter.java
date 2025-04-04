package com.restaurant.domain.model;

/**
 * Represents a waiter in the restaurant domain.
 */
public class Waiter {
    private String id;
    private String name;

    public Waiter() {
    }

    public Waiter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
