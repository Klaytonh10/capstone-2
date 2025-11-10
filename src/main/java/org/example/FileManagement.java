package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.vandermeer.asciitable.AsciiTable;
import org.example.products.MenuItem;
import org.example.products.Product;
import org.example.products.food.Dish;
import org.example.products.food.Topping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        root.put("order", fileSignature);
        ArrayList<MenuItem> items = order.getAllProducts();
        for(MenuItem item: items){
            ObjectNode nextProduction = objectMapper.createObjectNode();
            nextProduction.put("name", item.getName());
            nextProduction.put("price", item.getPrice());
            nextProduction.put("description", item.getDescription());
            nextProduction.put("size", item.getSize());
            if (item instanceof Dish) {
                ObjectNode nextTopping = objectMapper.createObjectNode();
                ArrayList<Topping> toppings = ((Dish) item).getToppings();
                for (Topping topping : toppings) {
                    nextTopping.put("topping-name",topping.getName());
                    nextTopping.put("topping-price", topping.getPrice());
                }
                nextProduction.set("topping", nextTopping);
            }
            root.set("menu-item", nextProduction);
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, root);

        // Write data here


        // Display receipt
        //AsciiTable at = new AsciiTable();
        //at.addRule(); // adds line
        //at.addRow("Item", "Qty", "Price");
        //at.addRule();
        //at.addRow("Coffee", "1", "$3.00");
        //at.addRule();
        //at.addRow("Donut", "2", "$4.00");
        //at.addRule();
        //System.out.println(at.render());
    }

}
