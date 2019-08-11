package com.pmareke;

public class App {
    public static void main(String[] args) {
        Burger burger = new BurgerBuilder(14)
                .AddPepperoni()
                .AddLettuce()
                .AddTomato()
                .Build();

        System.out.println(burger);
    }
}
