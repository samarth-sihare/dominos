package com.bitwise.dominos.pizzastore;

import com.bitwise.dominos.pizza.Pizza;

@FunctionalInterface
interface PizzaSelector {
    Pizza pizza();
}
