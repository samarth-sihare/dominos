package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Crust;

@FunctionalInterface
public interface CrustSelector {
    Crust crust();
}
