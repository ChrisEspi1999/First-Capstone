package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CaTEringCapstoneCLI {

    private Menu menu;


    private double change;
    private List<Product> productList = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);
    private double balance = 0; // BigDecimal?
    private double currentMoneyAvailable = 0;
    boolean keepGoing = true;


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

        do {
            this.menu.DisplayMainMenu();

            System.out.println("Main Menu Options: ");
            String menuInput = userInput.nextLine().toUpperCase();

            if (menuInput.equals("D")) {
                displayItems();
            }
            if (menuInput.equals("P")) {
                purchaseItems();
            }
            if (menuInput.equals("E")) {
                keepGoing = false;
                System.out.println("Have a good day!");
                System.exit(0);
            }
        } while (keepGoing);

    }

    public void displayItems() {

        System.out.println("Available Items: ");
        for (Product product : productList)
            System.out.println(product.getLocation() + " " + product.getName() + " " + product.getType() + " " + product.getPrice() + " " + product.getQuantity());
    }

    public void purchaseItems(){

        do {
            this.menu.DisplayPurchaseMenu();

            System.out.println("Purchase Menu Options: ");
            String menuInput = userInput.nextLine().toUpperCase();

            if (menuInput.equals("M")) {
                feedMoney();
            }
            if (menuInput.equals("S")) {
                selectItems();
            }
            if (menuInput.equals("F")) {
                System.out.println("Have a good day!");
                keepGoing = false;
                System.exit(0);
            }
        } while (keepGoing);
    }

    public void feedMoney(){
        do{
            System.out.println("Insert money (Accepts $1, $5, $10, or $20) or enter (B) to return to Purchase Menu: ");
            int moneyInput = Integer.parseInt(userInput.nextLine());

            if(moneyInput == 1 || moneyInput == 5 || moneyInput == 10 || moneyInput == 20){
                currentMoneyAvailable += 1.0 * moneyInput;
            }
            else{
                System.out.println("Invalid Input");
            }

            System.out.println("Current money available: " + currentMoneyAvailable);

            if(userInput.nextLine().equals("B")){
                keepGoing = false;
            }
        }while(keepGoing);
    }

    public void selectItems(){

        System.out.println("Select an Item: ");

        for (Product product : productList)
            System.out.println(product.getLocation() + " " + product.getName() + " " + product.getType() + " " + product.getPrice() + " " + product.getQuantity());

        String itemInput = userInput.nextLine().toUpperCase();

        if()


    }


}



