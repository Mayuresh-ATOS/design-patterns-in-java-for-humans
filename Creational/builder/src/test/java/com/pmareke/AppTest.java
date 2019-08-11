package com.pmareke;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithSize() {
        Burger burger = new BurgerBuilder(10)
                .AddPepperoni()
                .AddLettuce()
                .AddTomato()
                .Build();

        assertTrue(burger.size == 10);
    }

    @Test
    public void shouldAnswerWithPepperoni() {
        Burger burger = new BurgerBuilder(14)
                .AddPepperoni()
                .AddLettuce()
                .AddTomato()
                .Build();

        assertTrue(burger.pepperoni.equals(true));
    }

    @Test
    public void shouldAnswerWithoutPepperoni() {
        Burger burger = new BurgerBuilder(14)
                .AddLettuce()
                .AddTomato()
                .Build();

        assertTrue(burger.pepperoni.equals(false));
    }
}
