package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Pizza;

@FunctionalInterface
interface PizzaSelector {
    Pizza pizza();
}
