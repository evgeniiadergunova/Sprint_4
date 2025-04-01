package edu.praktikum.sprint2.model;

import edu.praktikum.sprint2.model.model.constants.Discount;

public abstract class Food implements Discountable {
    protected int amount;
    protected double price;
    protected boolean isVegetarian;
    protected Discount discount = new Discount();


    public Food(int amount, double price) {
        this.amount = amount;
        this.price = price;


    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public double getPrice() {
        return price;
    }


}
