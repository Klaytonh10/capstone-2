package org.example.products.food;

import org.example.products.Product;

public abstract class Topping implements Product {

    private String name;
    private double price;
    private boolean isPremium;
    private boolean isExtra;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    @Override
    public double getPrice() {

        if(isExtra && isPremium) {
            price *= 2;
        }

        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
