package com.bitwise.dominos.pizza;

import com.bitwise.dominos.ordermaking.Order;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestValidator {
    protected void validateOrderTotal(double expected, Order order) {
        assertEquals(expected, order.calculateTotalWithTax(),0.1);
    }
}
