package com.bitwise.dominos.resource.pizza;

import com.bitwise.dominos.api.ItemsRepository;
import com.bitwise.dominos.api.PizzaDS;
import com.bitwise.dominos.api.ToppingsDS;
import com.bitwise.dominos.pizza.Pizza;
import com.bitwise.dominos.pizza.Topping;
import com.bitwise.dominos.pizzadb.PizzaDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public class PizzasRepository  implements ItemsRepository {

    //private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private final List<PizzaDS> pizzaList;

    public PizzasRepository(){
        pizzaList = fetchPizzas();
    }

    private List<PizzaDS> fetchPizzas() {
        List<PizzaDS> pl = new ArrayList<>();
        for (PizzaDB pDB : PizzaDB.values()) {
            Pizza p = pDB.pizza();
            pl.add(new PizzaDS(p.getName(),p.getPrice(),fetchToppings(p.getToppingsList()),p.getCrust()));
        }
        return pl;
    }

    private List<ToppingsDS> fetchToppings(HashMap<Topping,Boolean> t){
        List<ToppingsDS> tl = new ArrayList<>();
        for (Topping topping : t.keySet()) {
            tl.add(new ToppingsDS(topping.getToppingName(),topping.getPrice()));
        }
        return tl;
    }


    @Override
    public List<PizzaDS> getItems() {
        return pizzaList;
    }
}
