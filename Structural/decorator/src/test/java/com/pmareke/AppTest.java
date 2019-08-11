package com.pmareke;

import com.pmareke.models.MilkCoffee;
import com.pmareke.models.SimpleCoffee;
import com.pmareke.models.VanillaCoffee;
import com.pmareke.models.WhipCoffee;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithSimpleCoffee() {
        SimpleCoffee simpleCoffee = new SimpleCoffee();
        assertTrue(simpleCoffee.getCost() == 10);
        assertTrue(simpleCoffee.getDescription().equals("Simple coffee"));
    }

    @Test
    public void shouldAnswerWithMilkCoffee() {
        SimpleCoffee simpleCoffee = new SimpleCoffee();
        MilkCoffee milkCoffee = new MilkCoffee(simpleCoffee);
        assertTrue(milkCoffee.getCost() == 12);
        assertTrue(milkCoffee.getDescription().equals("Simple coffee, milk"));
    }

    @Test
    public void shouldAnswerWithWhipCoffee() {
        SimpleCoffee simpleCoffee = new SimpleCoffee();
        WhipCoffee whipCoffee = new WhipCoffee(simpleCoffee);
        assertTrue(whipCoffee.getCost() == 15);
        assertTrue(whipCoffee.getDescription().equals("Simple coffee, whip"));
    }

    @Test
    public void shouldAnswerWithVanillaCoffee() {
        SimpleCoffee simpleCoffee = new SimpleCoffee();
        VanillaCoffee vanillaCoffee = new VanillaCoffee(simpleCoffee);

        assertTrue(vanillaCoffee.getCost() == 13);
        assertTrue(vanillaCoffee.getDescription().equals("Simple coffee, vanilla"));
    }
}
