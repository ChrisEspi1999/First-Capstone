package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CaTEringCapstoneCLI {

    private Menu menu;

    private List<Product> productList = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);
    private double balance = 0; // BigDecimal?
    private double currentMoneyAvailable = 0;
    boolean keepGoing = true;
    private String change = "";


    public CaTEringCapstoneCLI(Menu menu) { // audit parameter?

        this.menu = menu;
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
        System.out.println("Main Menu Options: ");
        displayMainMenu();

    }

    public void displayMainMenu(){
        do {

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
                System.out.println("Invalid input");
            }

        } while (keepGoing);
    }

    public void displayItems() {

        System.out.println("Available Items: ");
        for (Product product : productList)
            System.out.println(product.getLocation() + " " + product.getName() + " " + product.getType() + " $" + product.getPrice() + " Available: " + product.getQuantity());
    }

    public void purchaseItems() {

        do {
            System.out.println("Purchase Menu Options: ");
            this.menu.DisplayPurchaseMenu();
            System.out.println("Current available balance: $" + String.format("%.2f", currentMoneyAvailable)
            );

            String menuInput = userInput.nextLine().toUpperCase();

            if (menuInput.equals("M")) {
                feedMoney();
            } else if (menuInput.equals("S")) {
                selectItems();
            } else if (menuInput.equals("F")) {

                getChange();
                System.out.println("Transaction finished");
                System.out.println(change);

                keepGoing = false;
                displayMainMenu();

            } else {
                System.out.println("Invalid input");
            }
        } while (keepGoing);
    }

    public String getChange(){

        int dollars = (int) currentMoneyAvailable;
        double changeMinusDollars = currentMoneyAvailable - (1.0 * dollars);
        int quarters = (int) (changeMinusDollars / 0.25);
        double changeMinusQuarters = changeMinusDollars - (quarters * 0.25);
        int dimes = (int) (changeMinusQuarters / 0.10);
        double changeMinusDimes = changeMinusQuarters - (dimes * 0.1);
        int nickels = (int) (changeMinusDimes / 0.05);

        change = "Change: " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels";
        currentMoneyAvailable = 0;
        return change;
    }

    public void feedMoney() {
        do {
            System.out.println("Insert money (Accepts $1, $5, $10, or $20) or enter 0 to return to Purchase Menu: ");
            int moneyInput = Integer.parseInt(userInput.nextLine());

            if (moneyInput == 1 || moneyInput == 5 || moneyInput == 10 || moneyInput == 20) {
                currentMoneyAvailable += 1.0 * moneyInput;
                System.out.println("Current money available: $" + String.format("%.2f", currentMoneyAvailable));
            } else if (moneyInput == 0) {
                purchaseItems();
            } else {
                System.out.println("Invalid Input");
            }


        } while (keepGoing);
    }

    public void selectItems() {

        System.out.println("Select an Item: ");

        for (Product product : productList)
            System.out.println(product.getLocation() + " " + product.getName() + " " + product.getType() + " $" + product.getPrice() + " Available: " + product.getQuantity());

        String itemInput = userInput.nextLine().toUpperCase();

        try{
            for (Product product : productList) {

                if (product.getLocation().equals(itemInput)) {
                    if (currentMoneyAvailable - product.getPrice() < 0) {
                        System.out.println("Not enough money");
                        purchaseItems();
                    } else {
                        product.decreaseInventory();
                        product.getSound();
                        currentMoneyAvailable -= product.getPrice();
                        System.out.println();
                        purchaseItems();
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Invalid selection");
            purchaseItems();
        }
    }
}






