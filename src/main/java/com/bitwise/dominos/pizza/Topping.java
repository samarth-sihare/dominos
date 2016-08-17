package com.bitwise.dominos.pizza;

public class Topping {
    private final String toppingName;
    private final double price;

    public Topping(String toppingName, double price) {
        this.toppingName = toppingName;
        this.price = price;
    }

    public String getToppingName() { return toppingName; }
    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topping topping = (Topping) o;

        if (Double.compare(topping.price, price) != 0) return false;
        if (!toppingName.equals(topping.toppingName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = toppingName.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
