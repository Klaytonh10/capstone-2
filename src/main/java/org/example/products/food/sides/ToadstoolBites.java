package org.example.products.food.sides;

import org.example.products.food.Side;

public class ToadstoolBites extends Side {

    private final String name = "Toadstool Bites";
    private final double price = 1;
    private final String description = "Mini mushrooms that giggle when you eat them";

    public ToadstoolBites(String size) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

}
