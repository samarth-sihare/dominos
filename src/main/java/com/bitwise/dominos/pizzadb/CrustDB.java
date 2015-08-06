package com.bitwise.dominos.pizzadb;

import com.bitwise.dominos.pizza.Crust;

public enum CrustDB  implements CrustSelector{
    Regular(() -> new Crust("Regular",0)),
    PanPizza(() -> new Crust("Pan Pizza",100)),
    ThinCrust(() -> new Crust("Thin Crust",150)),
    CheeseBurst(() -> new Crust("Cheese Burst",200));

    private CrustSelector crustSelector;

    CrustDB(CrustSelector crustSelector){
        this.crustSelector = crustSelector;
    }

    @Override
    public Crust crust() {
        return crustSelector.crust();
    }

}
