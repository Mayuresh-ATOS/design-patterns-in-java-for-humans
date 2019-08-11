package com.pmareke;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        President p1 = President.getInstance();
        President p2 = President.getInstance();

        assertEquals(p1, p2);
    }
}
