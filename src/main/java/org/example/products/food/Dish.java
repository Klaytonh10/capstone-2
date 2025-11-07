package org.example.products.food;

import org.example.products.MenuItem;

import java.util.ArrayList;

public class Dish extends MenuItem {

    private ArrayList<Topping> toppings;

    public Dish() {

    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

}
