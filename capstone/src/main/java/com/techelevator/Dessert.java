package com.techelevator;

public class Dessert extends Product{

    public Dessert(String name, double price) {
        super(name, price);
    }

    @Override
    public void getSound(){
        System.out.println("Sugar, Sugar, So Sweet!");
    }
}
