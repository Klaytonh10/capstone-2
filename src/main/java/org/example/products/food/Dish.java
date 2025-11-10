package org.example.products.food;

import org.example.products.MenuItem;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private ArrayList<Topping> toppings;

    private String name = "Dish";

    public Dish(String size) {
        super.setName(name);
        super.setSize(size);
        super.setPrice(getPrice());
        super.setDescription(getDescription());
        this.toppings = new ArrayList<>();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public String getDescription() {
        return "";
    }

    public double getPrice() {
        return 0;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }
}
