package com.techelevator;

public class Sandwich extends Product{

    public Sandwich(String name, double price) {
        super(name, price);
    }

    @Override
    public void getSound(){
        System.out.println("Sandwich So Delicious, Yum!");
    }
}
