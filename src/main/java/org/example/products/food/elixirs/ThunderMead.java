package org.example.products.food.elixirs;

import org.example.products.food.Elixir;

public class ThunderMead extends Elixir {

    private final String name = "Thunder Mead";
    private final String description = "Honey-based soda that rumbles faintly in your chest after each sip";

    public ThunderMead(String size, double price) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return super.getSize();
    }

    public double getPrice() {
        return super.getPrice();
    }
}
