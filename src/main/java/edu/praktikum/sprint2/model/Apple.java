package edu.praktikum.sprint2.model;

import edu.praktikum.sprint2.model.model.constants.Colour;

public class Apple extends Food {
    private String colour;

    public Apple(int amount, double price, String colour) {
        super(amount, price);
        this.colour = colour;
        setVegetarian(true);

        if(colour.equals(Colour.red)) {
            discount.setDiscount(60);

        }



    }


    @Override
    public double getDiscount() {
        return discount.getDiscount();

    }


}


