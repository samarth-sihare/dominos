package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Topping;

@FunctionalInterface
interface ToppingsSelector {
    Topping topping();
}
