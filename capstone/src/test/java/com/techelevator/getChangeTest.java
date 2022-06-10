package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;

import static org.junit.Assert.*;

public class getChangeTest {

    private getChange tests;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Before
    public void setup() {
        this.tests = new getChange();
    }


    @Test
    public void test_change1(){

        double currentTest1 = 11.15;

        String expected1 = "CHANGE: Dollar bills: 11, Quarters: 0, Dimes: 1, Nickels: 1";
        String actual1 = tests.change(currentTest1);

        assertEquals(expected1, actual1);
    }

    @Test
    public void test_change2(){

        double currentTest2 = 20.00;

        String expected2 = "CHANGE: Dollar bills: 20, Quarters: 0, Dimes: 0, Nickels: 0";
        String actual2 = tests.change(currentTest2);

        assertEquals(expected2, actual2);
    }

    @Test
    public void test_change3(){

        double currentTest3 = 5;

        String expected3 = "CHANGE: Dollar bills: 5, Quarters: 0, Dimes: 0, Nickels: 0";
        String actual3 = tests.change(currentTest3);

        assertEquals(expected3, actual3);
    }

//    @Test
//    public void test_get_dollars() {
//        getChange test = new getChange();
//        double test1 = 11.15;
//        int expected = 11;
//        int actual = tests.getDollars();
//        assertEquals(expected, actual);
//    }
}



