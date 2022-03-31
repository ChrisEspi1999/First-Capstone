package com.techelevator;

public class Drink extends Product{

    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public void getSound(){
        System.out.println("Drinky, Drinky, Slurp Slurp!");
    }

}
