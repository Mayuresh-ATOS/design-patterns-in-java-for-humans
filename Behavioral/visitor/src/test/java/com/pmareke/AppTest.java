package com.pmareke;

import com.pmareke.models.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithSpeaks() {
        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        Speak speak = new Speak();
        Jump jump = new Jump();

        assertTrue(monkey.accept(speak).equals("Ooh oo aa aa!"));
        assertTrue(monkey.accept(jump).equals("Jumped 20 feet high! on to the tree!"));

        assertTrue(lion.accept(speak).equals("Roaaar!"));
        assertTrue(lion.accept(jump).equals("Jumped 7 feet! Back on the ground!"));

        assertTrue(dolphin.accept(speak).equals("Tuut tuttu tuutt!"));
        assertTrue(dolphin.accept(jump).equals("Walked on water a little and disappeared"));
    }
}
