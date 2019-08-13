package com.pmareke;

import com.pmareke.models.*;

public class App {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        Speak speak = new Speak();
        Jump jump = new Jump();

        System.out.println(monkey.accept(speak)); // Ooh oo aa aa!
        System.out.println(monkey.accept(jump)); // Jumped 20 feet high! on to the tree!

        System.out.println(lion.accept(speak)); // Roaaar!
        System.out.println(lion.accept(jump)); // Jumped 7 feet! Back on the ground!

        System.out.println(dolphin.accept(speak)); // Tuut tutt tuutt!
        System.out.println(dolphin.accept(jump)); // Walked on water a little and disappeared
    }
}
