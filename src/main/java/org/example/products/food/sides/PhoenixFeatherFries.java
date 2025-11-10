package org.example.products.food.sides;

import org.example.products.food.Side;

public class PhoenixFeatherFries extends Side {

    private final String name = "Phoenix Feather Fries";
    private final double price = 1;
    private final String description = "Always sizzling, never cooling down";

    public PhoenixFeatherFries(String size) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

}
