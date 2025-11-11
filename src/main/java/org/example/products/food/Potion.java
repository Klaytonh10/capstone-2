package org.example.products.food;

import org.example.products.MenuItem;

import java.util.ArrayList;

public class Potion extends MenuItem {

    private ArrayList<Topping> toppings = new ArrayList<>();

    private String name = "Potion";
    private String abilityType;
    private int abilityAmount;
    private double price = 0;

    public Potion() {
        super.setName(name);
    }

    public void setSize(String size) {
        super.setSize(size);
    }

    public String getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(String abilityType) {
        this.abilityType = abilityType;
    }

    public int getAbilityAmount() {
        return abilityAmount;
    }

    public void setAbilityAmount(int abilityAmount) {
        this.abilityAmount = abilityAmount;
    }

    public void addCost(double cost) {
        this.price += cost;
        super.setPrice(this.price);
    }

    public void subtractCost(double cost) {
        this.price -= cost;
        super.setPrice(this.price);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
        addCost(topping.getPrice());
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
        subtractCost(topping.getPrice());
    }

    public double getPrice() {
        return super.getPrice();
    }

    public String getDescription() {

        int petalNum = 0;
        int dustNum = 0;
        int seedNum = 0;
        int sprinkleNum = 0;

        for(Topping topping : toppings) {
            switch (topping.getName()) {
                case "Unicorn Sprinkles (Premium)":
                    sprinkleNum += 1;
                    break;
                case "Celestial Seeds (Premium)":
                    seedNum += 1;
                    break;
                case "Pixie Dust":
                    dustNum += 1;
                    break;
                case "Moon-flower Petals":
                    petalNum += 1;
                    break;
            }
        }

        return "Added " + this.getSize() + " " + this.abilityType + " potion with, " + petalNum + " Moonflower Petals, " + dustNum + " Pixie Dust, " + seedNum + " Celestial Seeds, " + sprinkleNum + " Unicorn Sprinkles, " + "For: $" + getPrice();
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

}
