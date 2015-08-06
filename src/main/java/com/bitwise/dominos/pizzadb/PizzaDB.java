package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Pizza;

public enum PizzaDB implements PizzaSelector {

    Margherita(() -> new Pizza("Margherita", 150).defaultToppings(ToppingsDB.Tomato.topping())),

    VegHawaiianDelight(() -> new Pizza("Veg. Hawaiian Delight",200)),

    NonVegHawaiianDelight(() -> new Pizza("NonVeg. Hawaiian Delight",220)),

    VeggieParadise(() -> new Pizza("Veggie Paradise",230)),

    PeppyPaneer(() -> new Pizza("Peppy Paneer",230)),

    ZestyChicken(() -> new Pizza("Zesty Chicken",280)),

    ChickenMaxicana(() -> new Pizza("Chicken Maxicana",300));

    private PizzaSelector selectedPizza;

    PizzaDB(PizzaSelector selectedPizza){
        this.selectedPizza = selectedPizza;
    }
    public Pizza pizza(){
        return selectedPizza.pizza();
    }



}
