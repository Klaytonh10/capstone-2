package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PremiumTopping2 extends Topping {

    private final String name = "Premium topping 2";
    private final double price = 2;
    private final boolean isPremium = true;
    private boolean isExtra = false;

    public PremiumTopping2(boolean isExtra) {
        super.setName(name);
        super.setPrice(super.getPrice());
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }
}
