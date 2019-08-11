package com.pmareke;

public class DoorFactory {
    public static WoodenDoor MakeDoor(float width, float height) {
        return new WoodenDoor(width, height);
    }
}
