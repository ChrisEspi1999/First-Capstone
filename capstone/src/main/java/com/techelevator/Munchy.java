package com.techelevator;

public class Munchy extends Product {

    private int quantity;


    public Munchy(String location, String name, String type, double price) {

        super(location, name, type, price);

    }

    public Munchy(String location, String name, String type, double price, int quantity) {
        super(location, name, type, price);
        this.quantity = quantity;
    }

    @Override
    public void getSound() {

        System.out.println("Munchy, Munchy, So Good!");

    }
}
