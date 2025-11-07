package org.example.sellables;

public abstract class MenuItem implements Product{

    private String name;
    private double price;

    @Override
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

}
