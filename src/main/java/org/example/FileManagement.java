package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.vandermeer.asciitable.AsciiTable;
import org.example.products.MenuItem;
import org.example.products.food.Potion;
import org.example.products.food.Topping;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileManagement {

    private static String fileWriteLocation = "src/main/resources/receipts/";

    public static void saveReceipt(Order order) throws IOException {

        // Get current DateTime to identify each individual receipt
        LocalDateTime fileDateName = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileSignature = fileDateName.format(dateTimeFormatter);

        // Directory to check if it exists
        File fileDirectory = new File(String.valueOf(fileWriteLocation));
        // Create new file with custom DateTime tag
        File file = new File(fileWriteLocation + fileSignature + ".json");

        // Create JSON structure
        ObjectMapper objectMapper = new ObjectMapper();

        // Root JSON object to build on
        ObjectNode root = objectMapper.createObjectNode();
        root.put("order-id", fileSignature);

        // New JSON array to add multiple objects to
        ArrayNode menuItemsArray = objectMapper.createArrayNode();

        // For each item, get the name, price, description, and size
        // If the item is a Potion(main dish), also get that topping name and price
        ArrayList<MenuItem> items = order.getAllProducts();
        for(MenuItem item: items){
            ObjectNode nextProduct = objectMapper.createObjectNode();
            nextProduct.put("name", item.getName());
            nextProduct.put("price", String.valueOf(item.getPrice()));
            nextProduct.put("description", item.getDescription());
            nextProduct.put("size", item.getSize());
            if (item instanceof Potion potion) {
                ArrayNode toppingsArray = objectMapper.createArrayNode();
                ArrayList<Topping> toppings = potion.getToppings();
                for (Topping topping : toppings) {
                    ObjectNode toppingNode = objectMapper.createObjectNode();
                    toppingNode.put("topping-name",topping.getName());
                    toppingNode.put("topping-price", topping.getPrice());
                    toppingsArray.add(toppingNode);
                }
                // Add each topping to array of toppings
                nextProduct.set("toppings", toppingsArray);
            }
            // Add each item to order array
            menuItemsArray.add(nextProduct);
        }

        // Add finished object to root object
        root.set("menu-items", menuItemsArray);

        //write object to file
        if(!fileDirectory.exists()) {
            fileDirectory.mkdir();
        }
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, root);

        // Display receipt in console
        AsciiTable at = new AsciiTable();
        at.addRule(); // adds line
        at.addRow("Item", "Size", "Price", "Description");
        at.addRule();
        for (MenuItem item : items) {
            if(item instanceof Potion potion){
                at.addRow(potion.getName(), potion.getSize(), String.valueOf(potion.getPrice()), potion.getDescription());
            } else {
                at.addRow(item.getName(), item.getSize(), String.valueOf(item.getPrice()), item.getReport());
            }
            at.addRule();
        }
        at.addRow("Total", " ", " ", "$" + order.getTotalPrice());
        at.addRule();
        at.addRow("Ability Power", " ", " ", order.getTotalAbilityPower());
        at.addRule();
        System.out.println(at.render());
    }

}
