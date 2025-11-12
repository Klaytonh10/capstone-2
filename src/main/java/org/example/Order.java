package org.example;

import org.example.products.MenuItem;
import org.example.products.Product;
import org.example.products.food.Potion;
import org.example.products.food.Elixir;
import org.example.products.food.Side;

import java.util.ArrayList;

public class Order {

    private ArrayList<MenuItem> products;

    private double totalPrice = 0;
    private boolean hasMain = false;

    public Order() {
        products = new ArrayList<>();
    }

    public boolean getHasMain() {
        return hasMain;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addPotion(Potion potion) {
        products.add(potion);
        this.hasMain = true;
        totalPrice += potion.getPrice();
    }

    public void addElixir(Elixir elixir) {
        products.add(elixir);
        totalPrice += elixir.getPrice();
    }

    public void addSide(Side side) {
        products.add(side);
        totalPrice += side.getPrice();
    }

    public int getTotalAbilityPower() {
        int allAbilityPower = 0;
        for(Product product : products) {
            if(product instanceof Potion potion) {
                allAbilityPower += potion.getAbilityAmount();
            }
        }
        return allAbilityPower;
    }

    public ArrayList<MenuItem> getAllProducts() {
        return products;
    }

}
