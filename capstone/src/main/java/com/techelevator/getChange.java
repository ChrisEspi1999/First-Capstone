
package com.techelevator;

import com.techelevator.view.Audit;

public class getChange {

    public String change(double currentMoneyAvailable) {

        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        dollars = (int) currentMoneyAvailable;
        double n = (double) (currentMoneyAvailable - dollars);

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

        String change = "CHANGE: " + "Dollar bills: " + dollars + ", Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels: " + nickels;

        return change;
    }
//
//    public int getDollars() {
//        return dollars;
//    }
//
//    public int getQuarters() {
//        return quarters;
//    }
//
//    public int getDimes() {
//        return dimes;
//    }
//
//    public int getNickels() {
//        return nickels;
//    }
}

