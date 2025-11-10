package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class PixieDust extends Topping {

    private final String name = "Topping 1";
    private final double price = .60;
    private final boolean isPremium = false;
    private boolean isExtra = false;

    public PixieDust(boolean isExtra) {
        super.setName(name);
        super.setPrice(super.getPrice());
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }
}
