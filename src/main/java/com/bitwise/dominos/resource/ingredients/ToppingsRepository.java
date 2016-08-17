package com.bitwise.dominos.resource.ingredients;

import com.bitwise.dominos.api.ItemsRepository;
import com.bitwise.dominos.api.ToppingsDS;
import com.bitwise.dominos.pizza.Topping;
import com.bitwise.dominos.pizzadb.ToppingsDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public class ToppingsRepository implements ItemsRepository {

    private final List<ToppingsDS> toppingsList;

    public ToppingsRepository(){
        toppingsList = fetchToppings();
    }

    private List<ToppingsDS> fetchToppings() {
        List<ToppingsDS> tl = new ArrayList<ToppingsDS>();

        for (ToppingsDB tdb : ToppingsDB.values()) {
            Topping t = tdb.topping();
            tl.add(new ToppingsDS(t.getToppingName(),t.getPrice()));
        }

        return tl;
    }

    @Override
    public List<ToppingsDS> getItems() {
        return toppingsList;
    }
}
