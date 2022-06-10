package com.techelevator;

import com.techelevator.view.Audit;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.*;

public class CaTEringCapstoneCLI {

    private Menu menu;

    private List<Product> productList = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);
    private double currentMoneyAvailable = 0;
    private String change = "";
    private String menuInput = "";
    private String purchaseInput = "";
    private String itemInput = "";
    private int moneyInput = 0;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

//    private BigDecimal currentMoneyAvailable = new BigDecimal("0.00");
//    private BigDecimal moneyInput = new BigDecimal("0.00");


    public CaTEringCapstoneCLI(Menu menu) {
        this.menu = menu;
    }

    public CaTEringCapstoneCLI() {

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
        cli.run();
    }

    public void run() {
        try {
            File file = new File("catering.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strArr = line.split("\\,");

                String location = strArr[0];
                String name = strArr[1];
                String type = strArr[2];
                double price = Double.parseDouble(strArr[3]);

                if (strArr[2].equals("Dessert")) {
                    productList.add(new Dessert(location, name, type, price));
                } else if (strArr[2].equals("Drink")) {
                    productList.add(new Drink(location, name, type, price));
                } else if (strArr[2].equals("Munchy")) {
                    productList.add(new Munchy(location, name, type, price));
                } else if (strArr[2].equals("Sandwich")) {
                    productList.add(new Sandwich(location, name, type, price));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println();
        }
        displayMainMenu();
    }

    public void displayMainMenu() {
        boolean keepGoing = true;
        do {
            System.out.println("MAIN MENU: ");
            this.menu.DisplayMainMenu();
            String menuInput = userInput.nextLine().toUpperCase();

            if (menuInput.equals("D")) {
                displayItems();
                System.out.println("");
            } else if (menuInput.equals("P")) {
                purchaseItems();
            } else if (menuInput.equals("E")) {
                keepGoing = false;
                System.out.println("Have a good day!");
                System.exit(0);
            } else {
                System.out.println("Invalid input, returning to MAIN MENU");
                System.out.println("");
            }
        } while (keepGoing);
    }

    public void displayItems() {
        System.out.println("AVAILABLE ITEMS: ");

        for (Product product : productList)
            System.out.println("(" + product.getLocation() + ") " + product.getName() + " " + product.getType() + ":\t $" + product.getPrice(itemInput) + "\t Available: " + product.getQuantity());
    }

    public void purchaseItems() {
        getChange dispense = new getChange();
        System.out.println("");
        boolean keepGoing = true;

        do {
            System.out.println("PURCHASE MENU: ");
            this.menu.DisplayPurchaseMenu();
            System.out.println("");
            System.out.println("Current available balance: $" + String.format("%.2f", currentMoneyAvailable));

            String menuInput = userInput.nextLine().toUpperCase();


            if (menuInput.equals("M")) {
                feedMoney();
            } else if (menuInput.equals("S")) {
                selectItems();
            } else if (menuInput.equals("F")) {

                System.out.println("Transaction finished");

                System.out.println(dispense.change(currentMoneyAvailable).toString());
                String balance = formatter.format(currentMoneyAvailable);

                currentMoneyAvailable = 0;
                String moneyStr = formatter.format(currentMoneyAvailable);

                String audit = new Audit().transaction(balance, moneyStr);

                keepGoing = false;
                displayMainMenu();

//                System.out.println("Transaction finished");
//
//                getChange();
//                System.out.println(change);
//
//                String balance = formatter.format(currentMoneyAvailable);
//                currentMoneyAvailable = 0;
//                String moneyStr = formatter.format(currentMoneyAvailable);
//                String audit = new Audit().transaction(balance, moneyStr);
//
//                keepGoing = false; // SOP after saying "returning to main menu
//                displayMainMenu();

            } else {
                System.out.println("Invalid input, returning to PURCHASE MENU");
                System.out.println("");
            }
        } while (keepGoing);
    }

    public void feedMoney() {
        System.out.println(""); // Exception for user inputting decimal number or letter- disconnects

        boolean keepGoing = true;

        try {
            do {
                System.out.println("INSERT MONEY: (Accepts $1, $5, $10, or $20) OR Enter 0 to return to PURCHASE MENU: ");
                int moneyInput = Integer.parseInt(userInput.nextLine());

                if (moneyInput == 1 || moneyInput == 5 || moneyInput == 10 || moneyInput == 20) {
                    currentMoneyAvailable += 1.0 * moneyInput;
                    String moneyAvailable = formatter.format(currentMoneyAvailable);
                    System.out.println("Current money available: " + moneyAvailable); // SOP ""
                } else if (moneyInput == 0) {
                    purchaseItems();
                } else {
                    System.out.println("Invalid Input, insert $1, $5, $10, or $20");
                    System.out.println("");
                }

                double input = moneyInput * 1.0;
                String audit = new Audit().moneyFeed(input, currentMoneyAvailable);
            } while (true);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }

    }

    public void selectItems() {
        System.out.println("");
        System.out.println("SELECT ITEM: ");

        for (Product product : productList) {
            System.out.println("(" + product.getLocation() + ") " + product.getName() + " " + product.getType() + ": $" + product.getPrice(itemInput) + " Available: " + product.getQuantity()); // ()

        }

        String itemInput = userInput.nextLine().toUpperCase();

        boolean isFound = false;
        for (Product product : productList) {

            if (product.getLocation().equals(itemInput)) {
                isFound = true;

                if (currentMoneyAvailable - product.getPrice(itemInput) < 0 && product.getLocation().equals(itemInput)) {
                    System.out.println("Not enough money");

                } else {
                    product.decreaseInventory();
                    if (product.getQuantity() != 0) {
                        product.getSound();
                        String balance = formatter.format(currentMoneyAvailable);
                        currentMoneyAvailable -= product.getPrice(itemInput);

                        String audit = new Audit().itemPurchased(product.getName(), product.getLocation(), balance, currentMoneyAvailable);
                    }
                }
            }
        }
        if (!isFound) {
            System.out.println("Invalid selection, returning to PURCHASE MENU");
        }
    }


    public String getChange() {

        String balance = formatter.format(currentMoneyAvailable);

        int dollars = (int) currentMoneyAvailable;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        double n = currentMoneyAvailable - dollars;

        while (n >= 0.25) {
            quarters++;
            n -= 0.25;
        }
        while (n >= 0.10) {
            dimes++;
            n -= 0.10;
        }
        while (n >= 0.05) {
            nickels++;
            n -= 0.05;
        }

        change = "CHANGE: " + "Dollar bills: " + dollars + ", Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels: " + nickels;
        System.out.println("");
        currentMoneyAvailable = 0;
        String moneyStr = formatter.format(currentMoneyAvailable);
        String audit = new Audit().transaction(balance, moneyStr);

        return change;
    }
}


