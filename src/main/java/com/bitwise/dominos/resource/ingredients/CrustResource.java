package com.bitwise.dominos.resource.ingredients;

import com.bitwise.dominos.api.CrustDS;
import com.bitwise.dominos.api.ItemsRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */

@Path("crusts")
@Produces(MediaType.APPLICATION_JSON)
public class CrustResource {

    private final ItemsRepository itemsRepository;

    public CrustResource(final ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @GET
    public List<CrustDS> getCrusts(){
        return itemsRepository.getItems();
    }

}
