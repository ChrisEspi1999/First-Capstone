package com.techelevator.view;

import com.techelevator.Product;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Audit {
    private final File output = new File("audit.txt");
    private LocalDateTime currentTime;


    public String moneyFeed(double input, double balance) {
        currentTime = LocalDateTime.now();
        return writeAudit(currentTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss ")) + " Money in: $" + input + " Balance:" + " $" + balance);
    }

    public String itemPurchased(String location, String name, String type, double cost, double balance) {
        currentTime = LocalDateTime.now();
        return writeAudit(currentTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + " " + location + " " + name + " " + location + " $" + cost + " $" + balance);
    }

    public String transaction(double change, double balance) {
        currentTime = LocalDateTime.now();
        return writeAudit(currentTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")) + " Change $" + change + " $" + balance);
    }

    private String writeAudit(String auditor) {
        String file = "";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(output, true))) {
            writer.println(auditor);
        } catch (FileNotFoundException e) {
            file = "File was not found.";
        }
        return file;
    }
}
