package com.bitwise.dominos.resource.ingredients;

import com.bitwise.dominos.api.CrustDS;
import com.bitwise.dominos.api.ItemsRepository;
import com.bitwise.dominos.pizza.Crust;
import com.bitwise.dominos.pizzadb.CrustDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public class CrustRepository implements ItemsRepository {


    private final List<CrustDS> crustsList;

    public CrustRepository(){
        crustsList = fetchCrusts();
    }

    private List<CrustDS> fetchCrusts() {
        List<CrustDS> cl = new ArrayList<CrustDS>();

        for (CrustDB cdb : CrustDB.values()) {
            Crust c = cdb.crust();
            cl.add(new CrustDS(c.getName(),c.getPrice()));
        }
        return cl;
    }

    @Override
    public  List<CrustDS> getItems() {
        return crustsList;
    }
}
