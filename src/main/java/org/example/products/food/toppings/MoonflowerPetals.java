package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class MoonflowerPetals extends Topping {

    private final String name = "Topping 2";
    private final double price = .50;
    private final boolean isPremium = false;
    private boolean isExtra = false;

    public MoonflowerPetals(boolean isExtra) {
        super.setName(name);
        super.setPrice(getPrice());
        super.setPremium(isPremium);
        super.setExtra(isExtra);
    }


    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}