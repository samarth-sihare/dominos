package com.bitwise.dominos.ordermaking;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final double VAT = 0.1;
    public static final double SERVICE_TAX = 0.15;
    private List<OrderLine> orderLines;

    public Order(){
        this.orderLines = new ArrayList<>();
    }

    public void addOrder(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    
    private double calculateTotal() {
        if(orderLines.size() == 0) throw new NoOrderAddedException("No order added");
        return orderLines.stream().mapToDouble(e -> e.getPrice()).sum();
    }

    public double calculateTotalWithTax() {
        return  calculate(VAT) + calculate(SERVICE_TAX) + calculateTotal();
    }

    private double calculate(double tax) {
        return calculateTotal() * tax;
    }

    public class NoOrderAddedException extends RuntimeException{
    	NoOrderAddedException(String messages){
    		super(messages);
    		
    	}
    }
}
