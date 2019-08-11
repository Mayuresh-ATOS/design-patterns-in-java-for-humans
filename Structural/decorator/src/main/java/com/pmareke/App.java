package com.pmareke;

import com.pmareke.models.MilkCoffee;
import com.pmareke.models.SimpleCoffee;
import com.pmareke.models.VanillaCoffee;
import com.pmareke.models.WhipCoffee;

public class App {
    public static void main(String[] args) {
        SimpleCoffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getCost()); // 10
        System.out.println(simpleCoffee.getDescription()); // Simple Coffee

        MilkCoffee milkCoffee = new MilkCoffee(simpleCoffee);
        System.out.println(milkCoffee.getCost()); // 12
        System.out.println(milkCoffee.getDescription()); // Simple Coffee, milk

        WhipCoffee whipCoffee = new WhipCoffee(simpleCoffee);
        System.out.println(whipCoffee.getCost()); // 17
        System.out.println(whipCoffee.getDescription()); // Simple Coffee, whip

        VanillaCoffee vanillaCoffee = new VanillaCoffee(simpleCoffee);
        System.out.println(vanillaCoffee.getCost()); // 20
        System.out.println(vanillaCoffee.getDescription()); // Simple Coffee, vanilla
    }
}
