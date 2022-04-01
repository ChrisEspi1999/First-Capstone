package com.techelevator;

import com.techelevator.view.Audit;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CaTEringCapstoneCLI {

    private Menu menu;

    private List<Product> productList = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);
    private double currentMoneyAvailable = 0;
    boolean keepGoing = true;
    private String change = "";
    private String menuInput = "";
    private String purchaseInput = "";
    private String itemInput = "";
    private int moneyInput = 0;

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
            System.out.println("(" + product.getLocation() + ") " + product.getName() + " " + product.getType() + ":\t $" + product.getPrice() + "\t Available: " + product.getQuantity());
    }

    public void purchaseItems() {
        System.out.println("");

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

                getChange();
                System.out.println("Transaction finished");
                System.out.println("");
                System.out.println(change);
                System.out.println("");

                keepGoing = false; // SOP after saying "returning to main menu
                displayMainMenu();

            } else {
                System.out.println("Invalid input, returning to PURCHASE MENU");
                System.out.println("");
            }
        } while (keepGoing);
    }

    public void feedMoney() {
        System.out.println(""); // Exception for user inputting decimal number or letter- disconnects

        try {
            do {
                System.out.println("INSERT MONEY: (Accepts $1, $5, $10, or $20) OR Enter 0 to return to PURCHASE MENU: ");
                int moneyInput = Integer.parseInt(userInput.nextLine());

                if (moneyInput == 1 || moneyInput == 5 || moneyInput == 10 || moneyInput == 20) {
                    currentMoneyAvailable += 1.0 * moneyInput;
                    System.out.println("Current money available: $" + String.format("%.2f", currentMoneyAvailable)); // SOP ""
                } else if (moneyInput == 0) {
                    purchaseItems();
                } else {
                    System.out.println("Invalid Input, insert $1, $5, $10, or $20");
                    System.out.println("");

                }
                String audit = new Audit().moneyFeed(moneyInput, currentMoneyAvailable);
            } while (keepGoing);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }

    }

    public void selectItems() {
        System.out.println("");
        System.out.println("SELECT ITEM: ");

        for (Product product : productList) {
            System.out.println("(" + product.getLocation() + ") " + product.getName() + " " + product.getType() + ": $" + product.getPrice() + " Available: " + product.getQuantity()); // ()
        }
        String itemInput = userInput.nextLine().toUpperCase();

        boolean isFound = false;
//        try {
            for (Product product : productList) {

                if (product.getLocation().equals(itemInput)) {
                    isFound = true;
                    if (currentMoneyAvailable - product.getPrice() < 0 && product.getLocation().equals(itemInput)) {
                        System.out.println("Not enough money");
                    } else {
                        product.decreaseInventory();
                        if (product.getQuantity() != 0) {
                            product.getSound();
                            currentMoneyAvailable -= product.getPrice();
                        }
                    }
//                }String audit = new Audit().itemPurchased()
            }if (!isFound){
            System.out.println("Invalid selection, returning to PURCHASE MENU");
        }
        }
    }



    public String getChange() {

        int dollars = (int) currentMoneyAvailable;
        double changeMinusDollars = currentMoneyAvailable - (1.0 * dollars);
        int quarters = (int) (changeMinusDollars / 0.25);
        double changeMinusQuarters = changeMinusDollars - (quarters * 0.25);
        int dimes = (int) (changeMinusQuarters / 0.10);
        double changeMinusDimes = changeMinusQuarters - (dimes * 0.1);
        int nickels = (int) (changeMinusDimes / 0.05);

        change = "CHANGE: " + "\r\n" + "Dollar bills: " + dollars + "\r\n" + "Quarters: " + quarters + "\r\n" + "Dimes: " + dimes + "\r\n" + "Nickels: " + nickels;
        System.out.println("");
        currentMoneyAvailable = 0;

        return change;
    }
}






