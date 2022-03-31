package com.techelevator;

public class Sandwich extends Product {

    public Sandwich(String location, String name, String type, double price) {
        super(location, name, type, price);
    }

    @Override
    public void getSound() {
        System.out.println("Sandwich So Delicious, Yum!");
    }
}
