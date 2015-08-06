package com.bitwise.dominos.pizza;

public class Crust {
    private final String name;
    private final double price;

    public Crust(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
