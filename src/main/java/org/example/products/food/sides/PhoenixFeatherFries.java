package org.example.products.food.sides;

import org.example.products.food.Side;

public class PhoenixFeatherFries extends Side {

    private final String name = "Phoenix Feather Fries";
    private double price;
    private final String description = "Always sizzling, never cooling down";

    public PhoenixFeatherFries(String size, double price) {
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
