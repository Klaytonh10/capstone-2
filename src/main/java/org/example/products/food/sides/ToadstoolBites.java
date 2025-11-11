package org.example.products.food.sides;

import org.example.products.food.Side;

public class ToadstoolBites extends Side {

    private final String name = "Toadstool Bites";
    private double price;
    private final String description = "Mini mushrooms that giggle when you eat them";

    public ToadstoolBites(String size, double price) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
        super.setReport(getReport());
    }

    public String getReport() {
        return getSize() + " " + getName() + " for $" + getPrice();
    }

}
