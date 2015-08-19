package com.bitwise.dominos.pizzastore;

import com.bitwise.dominos.pizza.Crust;

@FunctionalInterface
public interface CrustSelector {
    Crust crust();
}
