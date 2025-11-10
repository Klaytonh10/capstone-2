package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class MoonflowerPetal extends Topping {

    private final String name = "Moon-flower Petals";
    private final String ability = "Temporary Night Vision";
    private final double price = 2;
    private final boolean isPremium = false;
    private boolean isExtra = false;

    public MoonflowerPetal() {
        super.setName(name);
        super.setAbility(ability);
        super.setPrice(price);
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

}