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

    private static String fileWriteLocation = "src/main/resources/";

    public static void saveReceipt(Order order) throws IOException {
        LocalDateTime fileDateName = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileSignature = fileDateName.format(dateTimeFormatter);

        File file = new File(fileWriteLocation + fileSignature + ".json");

        // Create JSON structure
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode root = objectMapper.createObjectNode();
        root.put("order-id", fileSignature);

        ArrayNode menuItemsArray = objectMapper.createArrayNode();

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
                nextProduct.set("toppings", toppingsArray);
            }
            menuItemsArray.add(nextProduct);
        }

        root.set("menu-items", menuItemsArray);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, root);


        // Display receipt
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
        at.addRow("Total", " ", " ", order.getTotalPrice());
        at.addRule();
        System.out.println(at.render());
    }

}
