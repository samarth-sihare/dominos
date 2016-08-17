package com.bitwise.dominos.resource.pizza;

import com.bitwise.dominos.api.ItemsRepository;
import com.bitwise.dominos.api.PizzaDS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by kirankumarbs on 8/16/2016.
 */

@Path("/pizzas")
@Produces(MediaType.APPLICATION_JSON)
public class PizzasResource {

    private final ItemsRepository pRepository;

    public PizzasResource(final ItemsRepository pRepository){
        this.pRepository = pRepository;
    }

    @GET
    public List<PizzaDS> getPizzas(){
        return pRepository.getItems();
    }

    //private final PizzaSelector pizzaSelector;

}
