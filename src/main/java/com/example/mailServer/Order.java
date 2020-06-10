package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {
    private User user;
    private List<Product> products;

    public Order(@JsonProperty("user") User user,@JsonProperty("products") List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", products=" + products +
                '}';
    }
}
