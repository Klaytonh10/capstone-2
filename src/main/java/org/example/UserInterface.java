package org.example;

import org.example.products.food.Potion;
import org.example.products.food.toppings.MoonflowerPetal;
import org.example.products.food.toppings.PixieDust;
import org.example.products.food.toppings.PremiumCelestialSeed;
import org.example.products.food.toppings.PremiumUnicornSprinkle;

import java.util.Scanner;

public class UserInterface {

    static Order order;
    static Scanner scanner = new Scanner(System.in);
    static String input;

    static String size;
    static String abilityType;

    public static void start() {
        order = new Order();
        boolean running = true;

        while(running) {
            System.out.println("""

             ✨  ✨     ✨   ✨      ✨  ✨
             ╔═════════════════════════════╗
             ║      Magic Potion Shop      ║
             ╚═════════════════════════════╝

             1) New Order
             0) Exit
                  
             """);

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    System.out.println("\nShutting Down System");
                    running = !running;
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    private static void orderScreen() {
        boolean isOrdering = true;
        while(isOrdering){
            System.out.println("""
                    
                    ╔══════════════════════════════╗
                    ║  What would you like today?  ║
                    ╚══════════════════════════════╝
                    
                    1) Add Potion
                    2) Add Elixir
                    3) Add A Side
                    4) Checkout
                    0) Cancel Order
                    
                    """);

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    addPotionMenu();
                    break;
                case "2":
                    addElixirMenu();
                    break;
                case "3":
                    addSideMenu();
                    break;
                case "4":
                    checkoutMenu();
                    break;
                case "0":
                    isOrdering = false;
                    break;
            }
        }
    }

    private static void addPotionMenu() {

        Potion potion = new Potion();

        double price = 0;
        int abilityAmount = 0;

        size = null;
        abilityType = null;

        boolean isAddingToppings = true;

        boolean hasSeed = false;
        boolean hasSprinkles = false;

        while(size == null){
            System.out.println("""
                    
                    Size?
                    
                       Name      Price    Ability Amount
                            
                    1) Large:   10 Gold     3 Ability
                    2) Medium:  7 Gold      2 Ability
                    3) Small:   5 Gold      1 Ability
                    
                    """);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    size = "Large";
                    price += 10;
                    abilityAmount += 3;
                    break;
                case "2":
                    size = "Medium";
                    price += 7;
                    abilityAmount += 2;
                    break;
                case "3":
                    size = "small";
                    price += 5;
                    abilityAmount += 1;
                    break;
                default:
                    System.out.println("Please select (1), (2), or (3)");
                    break;
            }
        }

        potion.setSize(size);
        potion.setPrice(price);
        potion.setAbilityAmount(abilityAmount);

        while(abilityType == null) {
            System.out.println("""
                    
                    Type?
                    
                    1) Health
                    2) Strength
                    3) Stamina
                    
                    """);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    abilityType = "Health";
                    break;
                case "2":
                    abilityType = "Strength";
                    break;
                case "3":
                    abilityType = "Stamina";
                    break;
                default:
                    System.out.println("Please select (1), (2), or (3)");
                    break;
            }
        }
        potion.setAbilityType(abilityType);

        while (isAddingToppings) {
            System.out.println("""
                    
                    Toppings?
                    
                            Name                    Price       Gained Ability
                    
                    1) Moon-flower Petals          2 Gold   Temporary Night Vision
                    2) Pixie Dust                  1 Gold   Slightly Glowing Skin
                    3) Celestial Seeds (Premium)   5 Gold   Temporary Invisibility
                    4) Unicorn Sprinkles (Premium) 4 Gold   Temporary Flight
                    
                    0) Done
                    
                    """);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    potion.addTopping(new MoonflowerPetal());
                    break;
                case "2":
                    potion.addTopping(new PixieDust());
                    break;
                case "3":
                    potion.addTopping(new PremiumCelestialSeed(hasSeed));
                    hasSeed = true;
                    break;
                case "4":
                    potion.addTopping(new PremiumUnicornSprinkle(hasSprinkles));
                    hasSprinkles = true;
                    break;
                case "0":
                    isAddingToppings = !isAddingToppings;
                    break;
                default:
                    System.out.println("Please select (1), (2), or (3)");
                    break;
            }
        }
        order.addPotion(potion);
        System.out.println(potion.getDescription() + "\n");
    }

    private static void addElixirMenu() {

    }

    private static void addSideMenu() {

    }

    private static void checkoutMenu() {

    }

}
