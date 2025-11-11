package org.example.products.food.elixirs;

import org.example.products.food.Elixir;

public class SundropSpritz extends Elixir {

    private final String name = "Sundrop Spritz";
    private final String description = "Tiny starbursts that pop on your tongue";

    public SundropSpritz(String size, double price) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
        super.setReport(getReport());
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

    public String getReport() {
        return getSize() + " " + getName() + " for $" + getPrice();
    }
}
