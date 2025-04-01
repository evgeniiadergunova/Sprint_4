package edu.praktikum.sprint2.model;

public class Meat extends Food {

    public Meat(int amount, double price) {
        super(amount, price);
        setVegetarian(false);

    }


    @Override
    public double getDiscount() {
        return 0;
    }
}
