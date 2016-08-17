package com.bitwise.dominos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public class CrustDS {

    private final String name;
    private final double price;

    public CrustDS(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public double getPrice() {
        return this.price;
    }

}
