package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PremiumUnicornSprinkle extends Topping {

    private final String name = "Unicorn Sprinkles (Premium)";
    private final String ability = "Temporary Flight";
    private double price = 4;
    private final boolean isPremium = true;
    private boolean isExtra = false;

    public PremiumUnicornSprinkle() {
        super.setName(name);
        super.setAbility(ability);
        super.setPremium(isPremium);
        super.setExtra(isExtra);
        super.setPrice(getPrice());
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        if (isExtra) {
            return this.price * 2;
        } else {
            return this.price;
        }
    }
}
