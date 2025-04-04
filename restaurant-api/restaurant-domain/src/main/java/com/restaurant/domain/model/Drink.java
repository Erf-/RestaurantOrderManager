package com.restaurant.domain.model;

/**
 * Represents a drink item in the restaurant domain.
 */
public class Drink {
    private String id;
    private String name;
    private String description;
    private double price;
    private boolean alcoholic;

    public Drink() {
    }

    public Drink(String id, String name, String description, double price, boolean alcoholic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.alcoholic = alcoholic;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }
}
