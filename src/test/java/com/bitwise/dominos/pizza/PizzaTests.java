package com.bitwise.dominos.pizza;

import com.bitwise.dominos.ordermaking.Order;
import com.bitwise.dominos.ordermaking.OrderLine;
import com.bitwise.dominos.pizzastore.PizzaDB;
import org.junit.Test;

public class PizzaTests extends PizzaOrderTestValidator {

    @Test(expected = Order.NoOrderAddedException.class)
    public void itShouldGiveExceptionForNoOrderAdded(){
        //given
        Order order = new Order();
        //when
        order.calculateTotalWithTax();
        //then
    }

    @Test
    public void itShouldBeAbleToAddPizzaInOrderAndCalculateCost(){
        //given;
        OrderLine orderLine = new OrderLine(PizzaDB.Margherita.pizza());
        Order order = new Order();
        //when
        order.addOrder(orderLine);
        //then
        validateOrderTotal(187.5,order);
    }



    @Test
    public void itShouldBeAbleToAddMultiplePizzaInOrderAndCalculateCost(){
        //given
        OrderLine orderLine1 = new OrderLine(PizzaDB.Margherita.pizza());
        OrderLine orderLine2 = new OrderLine(PizzaDB.Margherita.pizza());

        Order order = new Order();
        //when
        order.addOrder(orderLine1);
        order.addOrder(orderLine2);

        //then 375
        validateOrderTotal(377, order);
    }



}
