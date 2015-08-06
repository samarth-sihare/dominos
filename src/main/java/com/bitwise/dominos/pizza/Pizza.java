package com.bitwise.dominos.pizza;

import java.util.HashMap;

public class Pizza {

    private final String pizzaName;
    private final double price;
    private HashMap toppingsList;
    private Crust crust;

    static Pizza pizzaCloneWithNewPrice(Pizza pizza, double newPrice){
        return new Pizza(pizza.getName(),pizza.getCrust(),pizza.getToppingsList(),newPrice);
    }

    Pizza(String pizzaName,Crust crust,HashMap<Topping,Boolean> toppingsList, double price){
        this.pizzaName = pizzaName;
        this.price = price;
        this.toppingsList = (HashMap)toppingsList.clone();
        this.crust = crust;
    }

    public Pizza(String pizzaName, double price) {
        this(pizzaName, new Crust("Regular", 0),new HashMap<>(), price);
    }

    void addTopping(Topping topping, Boolean isDefault){
        toppingsList.put(topping,isDefault);
    }

    public Pizza defaultToppings(Topping... toppings){
        for (Topping t : toppings) addTopping(t,true);
        return this;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return this.pizzaName;
    }

    Crust getCrust(){
        return this.crust;
    }

    HashMap<Topping,Boolean> getToppingsList(){
        return this.toppingsList;
    }


    void addCrust(Crust crust) {
        this.crust = crust;
    }

    void removeTopping(Topping topping) {
        if(!toppingsList.containsKey(topping))
            throw new NoSuchToppingOnPizza();
        toppingsList.remove(topping);
    }


    public class NoSuchToppingOnPizza extends RuntimeException{
    }
}
