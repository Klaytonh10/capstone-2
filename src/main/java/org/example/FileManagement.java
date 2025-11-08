package org.example;

import de.vandermeer.asciitable.AsciiTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManagement {

    private static String fileWriteLocation = "src/main/resources/";

    public static void saveReceipt(Order order) throws IOException {
        LocalDateTime fileDateName = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileSignature = fileDateName.format(dateTimeFormatter);

        File file = new File(fileWriteLocation + fileSignature + ".json");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        // Create JSON structure
        AsciiTable at = new AsciiTable();
        at.addRule(); // adds line
        at.addRow("Item", "Qty", "Price");
        at.addRule();
        at.addRow("Coffee", "1", "$3.00");
        at.addRule();
        at.addRow("Donut", "2", "$4.00");
        at.addRule();
        System.out.println(at.render());

        // Write data here

    }

}
