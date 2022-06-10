
package com.techelevator.view;

import com.techelevator.Product;

import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Audit {
    private static LocalDateTime currentTime;
    private static File output;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();


    public String moneyFeed(double input, double currentMoneyAvailable) {
        String moneyInput = formatter.format(input);
        String balanceStr = formatter.format(currentMoneyAvailable);
        currentTime = LocalDateTime.now();
        return writeAudit(currentTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss ")) + "Money in: " + moneyInput + " Balance:" + " " + balanceStr);
    }

    public String itemPurchased(String name, String location,String balance, double currentMoneyAvailable) {
        String moneyStr = formatter.format(currentMoneyAvailable);
        currentTime = LocalDateTime.now();
        return writeAudit(currentTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")) + " " + name + " (" + location + ") " + balance + " Balance: " + moneyStr);
    }

    public static String transaction(String balance, String moneyStr) {
        currentTime = LocalDateTime.now();
        return writeAudit(currentTime.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")) + " Change: " + balance + " Balance: " + moneyStr);
    }

    private static String writeAudit(String auditor) {
        File output = new File("audit.txt");
        String file = "";
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(output, true))) {
            writer.println(auditor);
        } catch (FileNotFoundException e) {
            file = "File was not found.";
        }
        return file;
    }
}


