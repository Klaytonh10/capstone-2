package org.example.products.food.elixirs;

import org.example.products.food.Elixir;

public class SundropSpritz extends Elixir {

    private final String name = "Sundrop Spritz";
    private final double price = 1;
    private final String description = "Tiny starbursts that pop on your tongue";

    public SundropSpritz(String size) {
        super.setName(name);
        super.setPrice(price);
        super.setDescription(description);
        super.setSize(size);
    }

}
