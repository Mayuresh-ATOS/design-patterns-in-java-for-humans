package com.pmareke;

public class App {
    public static void main(String[] args) {
        // Make me a door of 100x200
        WoodenDoor door = DoorFactory.MakeDoor(100, 200);

        System.out.println("Width " + door.getWidth() + " ");
        System.out.println("Height " + door.getHeight() + " ");

        // Make me a door of 50x100
        WoodenDoor door2 = DoorFactory.MakeDoor(50, 100);

        System.out.println("Width " + door2.getWidth() + " ");
        System.out.println("Height " + door2.getHeight() + " ");
    }
}
