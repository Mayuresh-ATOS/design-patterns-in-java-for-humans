package com.pmareke;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithClone() throws CloneNotSupportedException {
        Sheep original = new Sheep("Jolly", null);
        Sheep cloned = (Sheep) original.clone();

        cloned.setName("Dolly");
        cloned.setCategory("Cloned Sheep");

        assertTrue(original.getName().equals("Jolly"));
        assertTrue(original.getCategory().equals("Mountain Sheep"));

        assertTrue(cloned.getName().equals("Dolly"));
        assertTrue(cloned.getCategory().equals("Cloned Sheep"));
    }
}
