package org.example.products.food;

import org.example.products.MenuItem;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private ArrayList<Topping> toppings;

    public Dish() {
        this.toppings = new ArrayList<>();
    }

    public void setName(String name) {
        this.setName(name);
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

}
