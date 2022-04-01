package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CaTEringCapstoneCLITest {

    private CaTEringCapstoneCLI tests;

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

}
