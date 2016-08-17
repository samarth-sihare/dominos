package com.bitwise.dominos.resource.ingredients;

import com.bitwise.dominos.api.ToppingsDS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */

@Path("toppings")
@Produces(MediaType.APPLICATION_JSON)
public class ToppingsResource {

    private final ToppingsRepository toppingsRepository;

    public ToppingsResource(ToppingsRepository toppingsRepository) {
        this.toppingsRepository = toppingsRepository;
    }

    @GET
    public List<ToppingsDS> getToppings(){
        return toppingsRepository.getItems();
    }
}
