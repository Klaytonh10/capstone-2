package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PremiumCelestialSeeds extends Topping {

    private final String name = "Premium topping 2";
    private final double price = 2;
    private final boolean isPremium = true;
    private boolean isExtra = false;

    public PremiumCelestialSeeds(boolean isExtra) {
        super.setName(name);
        super.setPrice(super.getPrice());
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }
}
