package com.bitwise.dominos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public class ToppingsDS {

    private final String toppingName;
    private final double price;

    public ToppingsDS(String toppingName, double price) {
        this.toppingName = toppingName;
        this.price = price;
    }

    @JsonProperty
    public String getToppingName() { return toppingName; }

    @JsonProperty
    public double getPrice() { return price; }
}
