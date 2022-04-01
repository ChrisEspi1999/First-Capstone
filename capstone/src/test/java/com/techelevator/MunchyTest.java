package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MunchyTest {
    Munchy munchy = new Munchy("A1", "Nachos", "Munchy", 3.85);

    @Test
    public void test_get_location() {
        String expected = "A1";
        String actual = munchy.getLocation();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_name() {
        String expected = "Nachos";
        String actual = munchy.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_type() {
        String expected = "Munchy";
        String actual = munchy.getType();
        assertEquals(expected, actual);
    }

    @Test
    public void test_get_price() {
        double expected = 3.85;
        double actual = munchy.getPrice;
        assertEquals(expected, actual, expected);
    }

    @Test
    public void test_quantity() {
        int expected = 7;
        int actual = munchy.getQuantity();
        assertEquals(expected, actual);

    }
}









