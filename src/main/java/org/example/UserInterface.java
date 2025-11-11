package org.example;

import org.example.products.MenuItem;
import org.example.products.food.Elixir;
import org.example.products.food.Potion;
import org.example.products.food.Side;
import org.example.products.food.Topping;
import org.example.products.food.elixirs.SundropSpritz;
import org.example.products.food.elixirs.ThunderMead;
import org.example.products.food.sides.PhoenixFeatherFries;
import org.example.products.food.sides.ToadstoolBites;
import org.example.products.food.toppings.MoonflowerPetal;
import org.example.products.food.toppings.PixieDust;
import org.example.products.food.toppings.PremiumCelestialSeed;
import org.example.products.food.toppings.PremiumUnicornSprinkle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static Order order;
    static Scanner scanner = new Scanner(System.in);
    static String input;

    static String size;
    static String abilityType;

    static boolean isOrdering = true;

    public static void start() {
        boolean running = true;

        while (running) {
            order = new Order();
            System.out.println("""
                    
                    ✨  ✨     ✨   ✨      ✨  ✨
                    ╔═════════════════════════════╗
                    ║      Magic Potion Shop      ║
                    ╚═════════════════════════════╝
                    ✨  ✨     ✨   ✨      ✨  ✨
                    
                    1) New Order
                    0) Exit
                    
                    """);

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    System.out.println("\nShutting Down System\n");
                    running = !running;
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }
    }

    private static void orderScreen() {
        while (isOrdering) {
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
                    System.out.println("\nCanceling order...");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println("Thread Error " + e);
                    }
                    System.out.println("\nThis order was canceled\n");
                    isOrdering = false;
                    break;
            }
        }
    }

    private static void addPotionMenu() {

        Potion potion = new Potion();

        size = null;
        abilityType = null;

        boolean isAddingToppings = true;

        boolean hasSeed = false;
        boolean hasSprinkles = false;

        while (size == null) {
            System.out.println("""
                    
                    Size?
                    
                       Name      Price    Ability Amount
                    
                    1) Large:   10 Gold     6 Ability
                    2) Medium:  7 Gold      5 Ability
                    3) Small:   5 Gold      4 Ability
                    
                    """);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    size = input;
                    potion.setSize("Large");
                    potion.setPrice(10);
                    potion.setAbilityAmount(6);
                    break;
                case "2":
                    size = input;
                    potion.setSize("Medium");
                    potion.setPrice(7);
                    potion.setAbilityAmount(5);
                    break;
                case "3":
                    size = input;
                    potion.setSize("Small");
                    potion.setPrice(5);
                    potion.setAbilityAmount(4);
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }

        while (abilityType == null) {
            System.out.println("""
                    
                    Type?
                    
                    1) Health
                    2) Strength
                    3) Stamina
                    
                    """);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    abilityType = input;
                    potion.setAbilityType("Health");
                    break;
                case "2":
                    abilityType = input;
                    potion.setAbilityType("Strength");
                    break;
                case "3":
                    abilityType = input;
                    potion.setAbilityType("Stamina");
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }

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

            ArrayList<Topping> toppings = potion.getToppings();

            switch (input) {
                case "1":
                    potion.addTopping(new MoonflowerPetal());
                    System.out.println("Moon-Flower Petal Added");
                    break;
                case "2":
                    potion.addTopping(new PixieDust());
                    System.out.println("Pixie Dust Added");
                    break;
                case "3":
                    potion.addTopping(new PremiumCelestialSeed());
                    break;
                case "4":
                    potion.addTopping(new PremiumUnicornSprinkle());
                    break;
                case "0":
                    isAddingToppings = !isAddingToppings;
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }
        order.addPotion(potion);
        System.out.println("\n" + potion.getDescription() + "\n");
    }

    private static void addElixirMenu() {
        Elixir elixir = null;

        size = null;
        double price = 0;
        String flavor = null;

        while (size == null) {
            System.out.println("""
                    
                    ╔═════════════════════════════╗
                    ║        Add An Elixir        ║
                    ╚═════════════════════════════╝
                    
                    1) Large:   5 Gold
                    2) Medium:  3 Gold
                    3) Small:   1 Gold
                    
                    """);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    size = "Large";
                    price = 5;
                    break;
                case "2":
                    size = "Medium";
                    price = 3;
                    break;
                case "3":
                    size = "Small";
                    price = 1;
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }

        while (flavor == null) {
            System.out.println("""
                    
                    ╔═════════════════════════════╗
                    ║       Choose A Flavor       ║
                    ╚═════════════════════════════╝
                    
                    1) Sundrop Spritz   Tiny starbursts that pop on your tongue
                    2) Thunder Mead     Honey-based soda that rumbles faintly in your chest after each sip
                    
                    """);
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    flavor = input;
                    elixir = new SundropSpritz(size, price);
                    break;
                case "2":
                    flavor = input;
                    elixir = new ThunderMead(size, price);
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
            }
        }
        order.addElixir(elixir);
        System.out.println("\n" + elixir.getSize() + " " + elixir.getName() + " added for $" + elixir.getPrice() + "\n");
    }

    private static void addSideMenu() {
        Side side = null;
        size = null;
        double price = 0;
        String sideType = null;

        while (size == null) {
            System.out.println("""
                    
                    ╔══════════════════════════════╗
                    ║          Add A Side          ║
                    ╚══════════════════════════════╝
                    
                    1) Large:   6 Gold
                    2) Medium:  4 Gold
                    3) Small:   2 Gold
                    
                    """);
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    size = "Large";
                    price = 6;
                    break;
                case "2":
                    size = "Medium";
                    price = 4;
                    break;
                case "3":
                    size = "Small";
                    price = 2;
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }

        while (sideType == null) {
            System.out.println("""
                    
                    ╔══════════════════════════════╗
                    ║          Add A Side          ║
                    ╚══════════════════════════════╝
                    
                    1) Phoenix Feather Fries    Always sizzling, never cooling down
                    2) Toadstool Bites          Mini mushrooms that giggle when you eat them
                    
                    """);
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    sideType = input;
                    side = new PhoenixFeatherFries(size, price);
                    break;
                case "2":
                    sideType = input;
                    side = new ToadstoolBites(size, price);
                    break;
                default:
                    System.out.println("\nPlease select a valid option\n");
                    break;
            }
        }
        order.addSide(side);
        System.out.println("\n" + side.getSize() + " " + side.getName() + " added for $" + side.getPrice() + "\n");
    }

    private static void checkoutMenu() {
        ArrayList<MenuItem> items = order.getAllProducts();
        boolean isSaving = true;

        if (items.isEmpty()) {
            System.out.println("Please add an item to the order");
        } else {
            for (MenuItem item : items) {
                if (item instanceof Potion potion) {
                    System.out.println(potion.getDescription());
                    continue;
                }
                System.out.println(item.getName() + " for " + item.getPrice());
            }

            while (isSaving) {
                System.out.println("""
                        
                        
                        1) Confirm Order
                        2) Cancel Order (return to home screen)
                        
                        """);
                input = scanner.nextLine();
                switch (input) {
                    case "1":
                        try {
                            FileManagement.saveReceipt(order);
                            isSaving = false;
                            isOrdering = false;
                        } catch (IOException e) {
                            System.out.println("Save file failed " + e);
                        }
                        break;
                    case "2":
                        System.out.println("\nCanceling order...");
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            System.out.println("Thread Error " + e);
                        }
                        System.out.println("\nThis order was canceled\n");
                        isSaving = false;
                        isOrdering = false;
                        break;
                    default:
                        System.out.println("\nPlease select a valid option\n");
                        break;
                }
            }
        }
    }

}
