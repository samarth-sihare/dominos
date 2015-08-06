package com.bitwise.dominos;

import com.bitwise.dominos.ordermaking.Order;
import com.bitwise.dominos.ordermaking.OrderLine;
import com.bitwise.dominos.pizza.Pizza;
import com.bitwise.dominos.pizza.PizzaMaker;
import com.bitwise.dominos.pizza.PizzaOrderTestValidator;
import com.bitwise.dominos.pizzadb.CrustDB;
import com.bitwise.dominos.pizzadb.PizzaDB;
import com.bitwise.dominos.pizzadb.ToppingsDB;
import org.junit.Test;

public class PizzaOrder_3_Test extends PizzaOrderTestValidator{
    @Test
    public void creatingOrderNumberTwo(){
        //given
        Pizza veggieParadise = PizzaDB.VegHawaiianDelight.pizza();
        veggieParadise = PizzaMaker.addTopping(veggieParadise, ToppingsDB.Olives.topping());
        veggieParadise = PizzaMaker.addTopping(veggieParadise, ToppingsDB.Cheese.topping());
        veggieParadise = PizzaMaker.addCrust(veggieParadise, CrustDB.PanPizza.crust());

        Pizza nonVegHawaiianDelight = PizzaDB.NonVegHawaiianDelight.pizza();
        nonVegHawaiianDelight = PizzaMaker.addTopping(nonVegHawaiianDelight, ToppingsDB.BarbequeChicken.topping());
        nonVegHawaiianDelight = PizzaMaker.addCrust(nonVegHawaiianDelight, CrustDB.CheeseBurst.crust());

        Order order = new Order();
        //when
        order.addOrder(new OrderLine(veggieParadise));
        order.addOrder(new OrderLine(nonVegHawaiianDelight));

        //then 1068.75
        validateOrderTotal(1068.75, order);
    }
}
