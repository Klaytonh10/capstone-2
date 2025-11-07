package org.example.products;

import org.example.products.food.Topping;

import java.util.ArrayList;

public abstract class MenuItem implements Product {

    private String name;
    private String description;
    private String size;
    private double price;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        double sizePrice = 0;
        double equation = (price * sizePrice) + price;

        switch (size){
            case "small":
                sizePrice = .25;
                break;
            case "medium":
                sizePrice = .5;
                break;
            case "large":
                sizePrice = .75;
                break;
        }
        this.price = equation;

        return this.price;
    }

}
