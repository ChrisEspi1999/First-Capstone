package com.techelevator;

public class Drink extends Product {

    private int quantity;

    public Drink(String location, String name, String type, double price) {

        super(location, name, type, price);
    }

    public Drink(String location, String name, String type, double price, int quantity) {
        super(location, name, type, price);
        this.quantity = quantity;
    }

    @Override
    public void getSound() {
        System.out.println("Drinky, Drinky, Slurp Slurp!");

    }

}
