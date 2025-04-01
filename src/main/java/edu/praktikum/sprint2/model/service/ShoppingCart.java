package edu.praktikum.sprint2.model.service;


import edu.praktikum.sprint2.model.Food;

public class ShoppingCart {

    private Food[] foodArray;

    public ShoppingCart (Food[] foodArray) {
        this.foodArray = foodArray;
    }

    public double getItemsWithoutDiscount(){
        double totalPrice = 0;
        for (int i = 0; i< foodArray.length; i++) {
            if(foodArray[i].getDiscount() == 0) {
                totalPrice = totalPrice + foodArray[i].getPrice();
            }
        }
        return totalPrice;


    }

    public double getItemsWithDiscount() {
        double totalPrice = 0;
        for (int i = 0; i< foodArray.length; i++) {
            if(foodArray[i].getDiscount() != 0) {
                totalPrice = totalPrice + foodArray[i].getPrice();
            }
        }
        return totalPrice;

    }

    public double getVeganItemsWithoutDiscount() {
        double totalPrice = 0;
        for (int i = 0; i< foodArray.length; i++) {
            if((foodArray[i].getDiscount() == 0) && (foodArray[i].isVegetarian()) ) {
                totalPrice = totalPrice + foodArray[i].getPrice();
            }
        }
        return totalPrice;

    }


}
