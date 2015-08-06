package com.bitwise.dominos.pizza;

import com.bitwise.dominos.ordermaking.Order;
import com.bitwise.dominos.ordermaking.OrderLine;
import com.bitwise.dominos.pizzadb.CrustDB;
import com.bitwise.dominos.pizzadb.PizzaDB;
import com.bitwise.dominos.pizzadb.ToppingsDB;
import org.junit.Test;

public class OrderLineTest extends PizzaOrderTestValidator {

    @Test public void itShouldAllowToAddMultiplePizzaQuantityInSameOrderLine(){
        //given
        Pizza veggieParadise = PizzaDB.VegHawaiianDelight.pizza();
        Order order = new Order();
        //when

        order.addOrder(new OrderLine(veggieParadise,veggieParadise));
        //then

        validateOrderTotal(500,order);
    }

    @Test public void itShouldAllowToAddMultiplePizzaQuantityWhichAreCustomizedInSameOrderLine(){
        //given
        Pizza veggieParadise = PizzaDB.VegHawaiianDelight.pizza();
        veggieParadise = PizzaMaker.addCrust(veggieParadise, CrustDB.ThinCrust.crust());
        veggieParadise = PizzaMaker.addTopping(veggieParadise, ToppingsDB.Jalapeno.topping());

        Pizza veggieParadise1 = PizzaDB.VeggieParadise.pizza();

        Order order = new Order();
        //when

        order.addOrder(new OrderLine(veggieParadise,veggieParadise1));
        //then

        validateOrderTotal(743.75,order);
    }
}
