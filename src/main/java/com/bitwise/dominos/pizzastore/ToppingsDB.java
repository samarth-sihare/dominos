package com.bitwise.dominos.pizzastore;

import com.bitwise.dominos.pizza.Topping;

public enum ToppingsDB implements ToppingsSelector{
    Olives(() -> new Topping("Olives",15)),
    Jalapeno(() -> new Topping("Jalapeno",15)),
    Cheese(() -> new Topping("Cheese",20)),
    BarbequeChicken(() -> new Topping("Barbeque Chicken",100)),
    Tomato(() -> new Topping("Tomato", 10));

    private ToppingsSelector toppingsSelector;

    ToppingsDB(ToppingsSelector toppingsSelector){
        this.toppingsSelector = toppingsSelector;
    }

    @Override
    public Topping topping() {
        return toppingsSelector.topping();
    }
}
