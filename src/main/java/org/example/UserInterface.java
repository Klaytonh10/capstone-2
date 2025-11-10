package org.example;

import org.example.products.*;

import java.util.Scanner;

public class UserInterface {

    static Order order;
    static Scanner scanner = new Scanner(System.in);
    static String input;

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
                case "0":
                    running = !running;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    private static void orderScreen() {
        System.out.println("""
             ╔═════════════════════════════╗
             ║      Magic Potion Shop      ║
             ╚═════════════════════════════╝
             
             1) Add Potion
             2) Add Elixir
             3) Add A Side
             4) Checkout
             0) Cancel Order
             
                """);

        input = scanner.nextLine();
        switch (input)
    }


}
