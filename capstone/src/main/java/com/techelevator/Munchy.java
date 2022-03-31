package com.techelevator;

public class Munchy extends Product {

    public Munchy(String location, String name, String type, double price) {
        super(location, name, type, price);
    }

    @Override
    public void getSound() {
        System.out.println("Munchy, Munchy, So Good!");
    }
}
