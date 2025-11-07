package org.example.products.food.drinks;

import org.example.products.food.Drink;

public class Drink2 extends Drink {

    private final String name = "Sprite";
    private final double price = 1;
    private final String description = "";

    public Drink2(String size) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

}
