package com.example.pizza_loop;

public class Pizza {
    int pizzaId;
    String name;
    String details;
    double price;
    String imageURL;

    public Pizza() {
    }

    public Pizza(int pizzaId, String name, String details, double price, String imageURL) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.details = details;
        this.price = price;
        this.imageURL = imageURL;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }
}



