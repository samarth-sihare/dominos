package com.bitwise.dominos.pizzastore;

import com.bitwise.dominos.pizza.Topping;

@FunctionalInterface
interface ToppingsSelector {
    Topping topping();
}
