package com.bitwise.dominos.api;

import com.bitwise.dominos.pizza.Crust;
import com.bitwise.dominos.pizza.Topping;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public class PizzaDS {

    private final String pizzaName;
    private final double price;
    private final List<ToppingsDS> toppingsList;
    private final Crust crust;

    public PizzaDS(String pn,double p,List<ToppingsDS> tl,Crust c){
        this.pizzaName = pn;
        this.price = p;
        this.toppingsList = tl;
        this.crust = c;
    }

    @JsonProperty
    public String getPizzaName() {
        return pizzaName;
    }
    @JsonProperty
    public double getPrice() {
        return price;
    }
    @JsonProperty
    public List<ToppingsDS> getToppingsList() {
        return toppingsList;
    }
    @JsonProperty
    public Crust getCrust() {
        return crust;
    }
}
