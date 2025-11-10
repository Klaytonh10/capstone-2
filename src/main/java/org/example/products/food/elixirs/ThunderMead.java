package org.example.products.food.elixirs;

import org.example.products.food.Drink;

public class ThunderMead extends Drink {

    private final String name = "Thunder Mead";
    private final double price = 1;
    private final String description = "Honey-based soda that rumbles faintly in your chest after each sip";

    public ThunderMead(String size) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

}
