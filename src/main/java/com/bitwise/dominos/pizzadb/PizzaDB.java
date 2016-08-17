package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Pizza;

public enum PizzaDB implements PizzaSelector {

    Margherita(() -> new Pizza("Margherita", 150).defaultToppings(ToppingsDB.Tomato.topping())),

    VegHawaiianDelight(() -> new Pizza("Veg. Hawaiian Delight",200).defaultToppings(ToppingsDB.Jalapeno.topping())),

    NonVegHawaiianDelight(() -> new Pizza("NonVeg. Hawaiian Delight",220).defaultToppings(ToppingsDB.BarbequeChicken.topping())),

    VeggieParadise(() -> new Pizza("Veggie Paradise",230).defaultToppings(ToppingsDB.Tomato.topping(),ToppingsDB.Olives.topping())),

    PeppyPaneer(() -> new Pizza("Peppy Paneer",230).defaultToppings(ToppingsDB.Olives.topping(),ToppingsDB.Jalapeno.topping())),

    ZestyChicken(() -> new Pizza("Zesty Chicken",280).defaultToppings(ToppingsDB.BarbequeChicken.topping())),

    ChickenMaxicana(() -> new Pizza("Chicken Maxicana",300).defaultToppings(ToppingsDB.Cheese.topping(),ToppingsDB.BarbequeChicken.topping(),ToppingsDB.Jalapeno.topping()));

    private PizzaSelector selectedPizza;

    PizzaDB(PizzaSelector selectedPizza){
        this.selectedPizza = selectedPizza;
    }
    public Pizza pizza(){
        return selectedPizza.pizza();
    }



}
