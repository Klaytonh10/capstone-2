package org.example;

public class UserInterface {

    public static void start() {
        try {
            FileManagement.saveReceipt(new Order());
        } catch (Exception e) {

        }
    }

}
