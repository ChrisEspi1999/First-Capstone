package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {
    Drink drink = new Drink("A3", "Mountain Melter", "Drink", 2.35);

    @Test
    public void test_get_location(){
        String expected = "A3";
        String actual = drink.getLocation();
        assertEquals(expected,actual);
    }
    @Test
    public void test_get_name(){
        String expected = "Mountain Melter";
        String actual = drink.getName();
        assertEquals(expected,actual);
    }
    @Test
    public void test_get_type(){
        String expected = "Drink";
        String actual = drink.getType();
        assertEquals(expected,actual);
    }
    @Test
    public void test_get_price(){
        double expected =2.35;
        double actual = drink.getPrice;
        assertEquals(expected,actual,expected);
    }
    @Test
    public void test_quantity(){
        int expected = 7;
        int actual = drink.getQuantity();
        assertEquals(expected,actual);

    }

}
