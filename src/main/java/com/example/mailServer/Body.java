package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
    private Order order;

    public Body(@JsonProperty("body") Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
