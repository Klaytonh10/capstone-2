package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PremiumCelestialSeed extends Topping {

    private final String name = "Celestial Seeds (Premium)";
    private final String ability = "Temporary Invisibility";
    private double price = 5;
    private final boolean isPremium = true;
    private boolean isExtra = false;

    public PremiumCelestialSeed(boolean isExtra) {
        super.setName(name);
        super.setAbility(ability);
        super.setExtra(isExtra);
        super.setPremium(isPremium);
        super.setPrice(this.price);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return super.getPrice();
    }
}
