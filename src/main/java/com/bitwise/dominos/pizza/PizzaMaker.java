package com.bitwise.dominos.pizza;

public class PizzaMaker {

    public static Pizza addTopping(Pizza pizza, Topping topping) {
        Pizza newPizza = Pizza.pizzaCloneWithNewPrice(pizza, pizza.getPrice() + topping.getPrice());
        newPizza.addTopping(topping, false);
        return newPizza;
    }

    public static Pizza addCrust(Pizza pizza, Crust crust) {
        Pizza newPizza = Pizza.pizzaCloneWithNewPrice(pizza, pizza.getPrice() + crust.getPrice());
        newPizza.addCrust(crust);
        return newPizza;
    }

    public static Pizza removeTopping(Pizza pizza, Topping topping) {
        Pizza newPizza = Pizza.pizzaCloneWithNewPrice(pizza, pizza.getPrice() - topping.getPrice());
        newPizza.removeTopping(topping);
        return newPizza;
    }
}
