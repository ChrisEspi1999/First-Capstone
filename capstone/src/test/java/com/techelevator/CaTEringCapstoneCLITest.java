package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CaTEringCapstoneCLITest {

    private CaTEringCapstoneCLI tests;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    @Before
    public void setup() {
        this.tests = new CaTEringCapstoneCLI();
    }

    @Test
    public void test_run(){
        String [] test = {"A1", "Nachos", "Munchy", "3.85"};
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(0, "A1");
        expectedResult.add(1,"Nachos");
        expectedResult.add(2, "Munchy");
        expectedResult.add(3, "3.85");
        assertEquals("A1", expectedResult.get(0));
        assertEquals("Nachos", expectedResult.get(1));
        assertEquals("Munchy", expectedResult.get(2));
        assertEquals("3.85", expectedResult.get(3));

    }
//    @Test
//    public void test_change1(){
//
//        String expected1 = "CHANGE: Dollar bills: 0, Quarters: 0, Dimes: 0, Nickels: 0";
//        String actual1 = tests.getChange();
//
//        assertEquals(expected1,actual1);
//
//    }

}


