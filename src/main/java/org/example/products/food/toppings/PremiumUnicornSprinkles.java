package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PremiumUnicornSprinkles extends Topping {

    private final String name = "Premium topping 1";
    private final double price = 1;
    private final boolean isPremium = true;
    private boolean isExtra = false;

    public PremiumUnicornSprinkles(boolean isExtra) {
        super.setName(name);
        super.setPrice(price);
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }
}
