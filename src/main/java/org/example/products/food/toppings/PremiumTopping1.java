package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PremiumTopping1 extends Topping {

    private final String name = "Premium topping 1";
    private double price = 1;
    private final boolean isPremium = true;
    private boolean isExtra = false;

    public PremiumTopping1(boolean isExtra) {
        super.setName(name);
        super.setPrice(price);
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }
}
