package com.techelevator;

import com.techelevator.view.Menu;

import java.util.ArrayList;
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
	private List<Product> list = new ArrayList<>();
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

		// Restock inventory (At the start of every run)

		while (true) {
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
	}
}
