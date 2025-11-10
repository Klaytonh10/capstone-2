package org.example.products.food;

import org.example.products.Product;

public abstract class Topping implements Product {

    private String name;
    private String ability;
    private double price;
    private boolean isPremium;
    private boolean isExtra;

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
