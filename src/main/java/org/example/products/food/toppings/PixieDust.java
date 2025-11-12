package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PixieDust extends Topping {

    private final String name = "Pixie Dust";
    private final String ability = "Slightly Glowing Skin";
    private final double price = 1;
    private final boolean isPremium = false;
    private boolean isExtra = false;

    public PixieDust() {
        super.setName(name);
        super.setAbility(ability);
        super.setPrice(price);
        super.setExtra(isExtra);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
