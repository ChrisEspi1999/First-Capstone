package com.techelevator;

public class Dessert extends Product{

    public Dessert(String location, String name, String type, double price) {
        super(location, name, type, price);
    }

    @Override
    public void getSound(){
        System.out.println("Sugar, Sugar, So Sweet!");
    }
}
