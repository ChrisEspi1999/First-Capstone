package com.techelevator;

public abstract class Product {

    public double getPrice;
    private String location;
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Product(String location, String name, String type, double price) {
        this.location = location;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = 7;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice(String itemInput) {
        return price;
    }

    public abstract void getSound();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decreaseInventory(){
        if(quantity == 0){
            System.out.println("Product is no longer available");
        }
        else{
            quantity--;
        }
    }
}
