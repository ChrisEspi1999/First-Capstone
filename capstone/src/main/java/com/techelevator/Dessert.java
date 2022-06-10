package com.techelevator;

public class Dessert extends Product{

    private int quantity;

    public Dessert(String location, String name, String type, double price) {

        super(location, name, type, price);
    }

    public Dessert(String location, String name, String type, double price, int quantity) {
        super(location, name, type, price);
        this.quantity = quantity;
    }

    @Override
    public void getSound(){
        System.out.println("Sugar, Sugar, So Sweet!");

    }
}
