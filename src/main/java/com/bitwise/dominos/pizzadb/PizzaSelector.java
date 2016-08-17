package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Pizza;

@FunctionalInterface
public interface PizzaSelector {
    Pizza pizza();
}
