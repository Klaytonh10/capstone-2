package org.example.products.food.toppings;

import org.example.products.food.Topping;

public class EtherealHoney extends Topping {

    private final String name = "Ethereal Honey";
    private final String ability = "25% chance that your next wish comes true";
    private final double price = 3;
    private final boolean isPremium = false;
    private boolean isExtra = false;

    public EtherealHoney() {
        super.setName(name);
        super.setAbility(ability);
        super.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }


}
