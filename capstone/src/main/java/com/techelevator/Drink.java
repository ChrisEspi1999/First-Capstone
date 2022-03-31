package com.techelevator;

public class Drink extends Product {

    public Drink(String location, String name, String type, double price) {
        super(location, name, type, price);
    }

    @Override
    public void getSound() {
        System.out.println("Drinky, Drinky, Slurp Slurp!");
    }

}
