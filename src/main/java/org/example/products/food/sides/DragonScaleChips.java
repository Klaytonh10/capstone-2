package org.example.products.food.sides;

import org.example.products.food.Side;

public class DragonScaleChips extends Side {

    private final String name = "Dragon Scale Chips";
    private double price;
    private final String description = "thin, shimmering crisps that crackle faintly";

    public DragonScaleChips(String size, double price) {
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
