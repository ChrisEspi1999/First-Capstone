package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SandwichTest {


    Sandwich sandwich = new Sandwich("A2", "Walking Tacos", "Sandwich", 5.25);

    @Test
    public void test_get_location() {
        String expected = "A2";
        String actual = sandwich.getLocation();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_name() {
        String expected = "Walking Tacos";
        String actual = sandwich.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_type() {
        String expected = "Sandwich";
        String actual = sandwich.getType();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_price() {
        double expected = 5.25;
        double actual = sandwich.getPrice;
        assertEquals(expected, actual, expected);
    }

    @Test
    public void test_quantity() {
        int expected = 7;
        int actual = sandwich.getQuantity();
        assertEquals(expected, actual);

    }}
