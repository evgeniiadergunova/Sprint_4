package edu.praktikum.sprint2.model;

import edu.praktikum.sprint2.model.model.constants.Colour;
import edu.praktikum.sprint2.model.service.ShoppingCart;

public class Main {
    public static void main(String[] args) {

        Meat meat = new Meat(5, 500);
        Apple redApple = new Apple(10, 500, Colour.red);
        Apple greenApple = new Apple(8, 480, Colour.green);

        Food[] foodArray = {meat, redApple, greenApple};
        ShoppingCart shoppingCart = new ShoppingCart(foodArray);

        System.out.println(shoppingCart.getItemsWithDiscount());
        System.out.println(shoppingCart.getItemsWithoutDiscount());
        System.out.println(shoppingCart.getVeganItemsWithoutDiscount());
    }
}
