package org.example.products.food.sides;

import org.example.products.food.Side;

public class Side1 extends Side {

    private final String name = "Onion rings";
    private final double price = 1;
    private final String description = "";

    public Side1(String size) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

}
