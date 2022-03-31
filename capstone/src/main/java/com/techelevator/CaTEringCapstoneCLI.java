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

    private static final String MAIN_MENU_DISPLAY_ITEMS = "(D) Display catering items";
    private static final String MAIN_MENU_PURCHASE = "(P) Purchase";
    private static final String MAIN_MENU_EXIT = "(E) Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_DISPLAY_ITEMS, MAIN_MENU_PURCHASE, MAIN_MENU_EXIT};

    private static final String PURCHASE_MENU_FEED_MONEY = "(M) Feed Money)";
    private static final String PURCHASE_MENU_SELECT_ITEM = "(S) Select Items)";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "(F) Finish transaction)";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_ITEM, PURCHASE_MENU_FINISH_TRANSACTION};

    private double change;
    private List<String> list = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);
    private double balance; // BigDecimal?


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

                List<Product> productList = new ArrayList<>();
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
    }
    public

        System.out.println("Welcome to our catering menu! \nPlease select an option.");
        boolean keepGoing = true;
        for (int i = 0; i < MAIN_MENU_OPTIONS.length; i++) {
            System.out.println(MAIN_MENU_OPTIONS[i]);
        }


        do {

            String menuInput = userInput.nextLine().toUpperCase();

            if (menuInput.equals("D")) {
                displayItems();
            }
            if (menuInput.equals("P")) {

            }
            if (menuInput.equals("E")) {
                keepGoing = false;
                System.out.println("Have a good day!");
                System.exit(0);
            }
        } while (keepGoing);
    }

    public void displayItems() {


//		 Restock inventory (At the start of every run)


        for (Product product : productList)
            System.out.println(product.getLocation() + product.getName());
    }


//		while (true) {
    //  to do -- build out main menu
			/*
				Loop:
			    Display Main Menu
			    Get User Choice
			    Display next menu/options accordingly
			 */

}

		/*
			Loop:
			Display Purchase Menu
			Get User Choice
			Display next menu/options accordingly
				- For each option: call method 
		*/

		}


