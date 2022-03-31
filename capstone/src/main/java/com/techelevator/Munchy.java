package com.techelevator;

public class Munchy extends Product{

    public Munchy(String name, double price) {
        super(name, price);
    }

    @Override
    public void getSound(){
        System.out.println("Munchy, Munchy, So Good!");
    }
}
