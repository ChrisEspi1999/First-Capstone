package com.techelevator.view;

import com.techelevator.Product;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

    public static final String MAIN_MENU_DISPLAY_ITEMS = "(D) Display catering items";
    public static final String MAIN_MENU_PURCHASE = "(P) Purchase";
    public static final String MAIN_MENU_EXIT = "(E) Exit";
    public static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_DISPLAY_ITEMS, MAIN_MENU_PURCHASE, MAIN_MENU_EXIT};

    public static final String PURCHASE_MENU_FEED_MONEY = "(M) Feed Money";
    public static final String PURCHASE_MENU_SELECT_ITEM = "(S) Select Items";
    public static final String PURCHASE_MENU_FINISH_TRANSACTION = "(F) Finish transaction";
    public static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_ITEM, PURCHASE_MENU_FINISH_TRANSACTION};

    public void DisplayMainMenu() {
        for (int i = 0; i < MAIN_MENU_OPTIONS.length; i++) {
            System.out.println(MAIN_MENU_OPTIONS[i]);
        }
    }

    public void DisplayPurchaseMenu() {
        for (int i = 0; i < PURCHASE_MENU_OPTIONS.length; i++) {
            System.out.println(PURCHASE_MENU_OPTIONS[i]);
        }
    }




}

