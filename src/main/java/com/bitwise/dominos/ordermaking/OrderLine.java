package com.bitwise.dominos.ordermaking;

import com.bitwise.dominos.pizza.Pizza;
import java.util.Arrays;
import java.util.List;

public class OrderLine {

    private final List<Pizza> pizzas;

    public OrderLine(Pizza... pizzas) {
        this.pizzas = Arrays.asList(pizzas);
    }

    public double getPrice() {
        return this.pizzas.stream().mapToDouble(e -> e.getPrice()).sum();
    }

}
