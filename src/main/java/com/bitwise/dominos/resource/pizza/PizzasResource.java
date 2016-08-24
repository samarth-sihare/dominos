package com.bitwise.dominos.resource.pizza;

import com.bitwise.dominos.api.ItemsRepository;
import com.bitwise.dominos.api.PizzaDS;
import com.bitwise.dominos.pizzadb.PizzaDB;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
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
