package com.techelevator.view;

import com.techelevator.Product;

import java.io.*;
import java.util.Date;

public class Audit {
    private static File output = new File("audit.txt");
    private static Date currentTime;

    public static void auditFile() {
        try {
            if (!output.exists()) {
                System.out.println("Creating File");
                output.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(output, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void purchasing(Product product) {
        auditFile();
        currentTime = new Date();
        String purchasing = product.getName();

    }
}
