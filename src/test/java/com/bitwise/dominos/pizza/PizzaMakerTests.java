package com.bitwise.dominos.pizza;

import com.bitwise.dominos.ordermaking.Order;
import com.bitwise.dominos.ordermaking.OrderLine;
import com.bitwise.dominos.pizzastore.CrustDB;
import com.bitwise.dominos.pizzastore.PizzaDB;
import com.bitwise.dominos.pizzastore.ToppingsDB;
import org.junit.Test;

public class PizzaMakerTests extends PizzaOrderTestValidator{
    @Test
    public void itShouldBeAbleToAddPizzaAndAddToppingAndCalculateCost(){
        //given
        Pizza pizza = PizzaDB.Margherita.pizza();
        pizza = PizzaMaker.addTopping(pizza, ToppingsDB.Olives.topping());
        OrderLine orderLine = new OrderLine(pizza);
        Order order = new Order();

        //when
        order.addOrder(orderLine);

        //then
        validateOrderTotal(206.25, order);
    }

    @Test
    public void itShouldBeAbleToAddPizzaAndAddMultipleToppingAndCalculateCost(){
        //given
        Pizza pizza = PizzaDB.Margherita.pizza();
        pizza = PizzaMaker.addTopping(pizza, ToppingsDB.Olives.topping());
        pizza = PizzaMaker.addTopping(pizza, ToppingsDB.Jalapeno.topping());
        OrderLine orderLine = new OrderLine(pizza);
        Order order = new Order();
        //when
        order.addOrder(orderLine);

        //then
        validateOrderTotal(225, order);
    }

    @Test
    public void itShouldBeAbleToAddMultiplePizzaAndAddMultipleToppingAndCalculateCost(){
        //given
        Pizza pizza = PizzaDB.Margherita.pizza();
        pizza = PizzaMaker.addTopping(pizza, ToppingsDB.Olives.topping());
        pizza = PizzaMaker.addTopping(pizza, ToppingsDB.Jalapeno.topping());

        Pizza pizza1 = PizzaDB.ChickenMaxicana.pizza();
        pizza1 = PizzaMaker.addTopping(pizza1, ToppingsDB.Olives.topping());
        pizza1 = PizzaMaker.addTopping(pizza1, ToppingsDB.Jalapeno.topping());

        OrderLine orderLine1 = new OrderLine(pizza);
        OrderLine orderLine2 = new OrderLine(pizza1);
        Order order = new Order();
        //when
        order.addOrder(orderLine1);
        order.addOrder(orderLine2);

        //then
        validateOrderTotal(637.5, order);
    }

    @Test
    public void itShouldBeAbleToAddPizzaAndAddCrustAndCalculateCost(){
        //given
        Pizza pizza = PizzaDB.Margherita.pizza();
        pizza = PizzaMaker.addCrust(pizza, CrustDB.PanPizza.crust());
        OrderLine orderLine = new OrderLine(pizza);
        Order order = new Order();
        //when
        order.addOrder(orderLine);

        //then
        validateOrderTotal(312.5, order);
    }

    @Test(expected = Pizza.NoSuchToppingOnPizza.class)
    public void itShouldNotAllowToppingToRemovedWhichIsNotPresent(){
        //given
        Pizza pizza = PizzaDB.Margherita.pizza();

        //when
        PizzaMaker.removeTopping(pizza, ToppingsDB.Olives.topping());
        //then

    }

    @Test
    public void itShouldAllowToRemoveToppingsAndGiveTotalCostOfPizza(){
        //given
        Pizza pizza = PizzaDB.Margherita.pizza();
        pizza = PizzaMaker.removeTopping(pizza,ToppingsDB.Tomato.topping());

        OrderLine orderLine = new OrderLine(pizza);
        Order order = new Order();
        //when
        order.addOrder(orderLine);

        //then
        validateOrderTotal(175, order);

    }
}
