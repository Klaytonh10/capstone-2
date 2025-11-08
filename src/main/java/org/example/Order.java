package org.example;

import org.example.products.MenuItem;
import org.example.products.Product;
import org.example.products.food.Dish;
import org.example.products.food.Drink;
import org.example.products.food.Side;

import java.util.ArrayList;

public class Order extends MenuItem {

    private ArrayList<MenuItem> products;

    private double totalPrice = 0;
    private boolean hasMain = false;

    public Order() {
        products = new ArrayList<>();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addDish(Dish dish) {
        products.add(dish);
        this.hasMain = true;
    }

    public void addDrink(Drink drink) {
        products.add(drink);
    }

    public void addSide(Side side) {
        products.add(side);
    }

    public ArrayList<Product> getAllProducts() {
        return null;
    }

}
