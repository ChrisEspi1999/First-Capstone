package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class DessertTest {

    Dessert dessert = new Dessert("A4", "Chocolate Bar", "Dessert", 1.75);

    @Test
    public void test_get_location(){
        String expected = "A4";
        String actual = dessert.getLocation();
        assertEquals(expected,actual);
    }
    @Test
    public void test_get_name(){
        String expected = "Chocolate Bar";
        String actual = dessert.getName();
        assertEquals(expected,actual);
    }
    @Test
    public void test_get_type(){
        String expected = "Dessert";
        String actual = dessert.getType();
        assertEquals(expected,actual);
    }
    @Test
    public void test_get_price(){
        double expected =3.85;
        double actual = dessert.getPrice;
        assertEquals(expected,actual,expected);
}
    @Test
    public void test_quantity(){
        int expected = 7;
        int actual = dessert.getQuantity();
        assertEquals(expected,actual);

    }
}
