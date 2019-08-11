package com.pmareke;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldCreateDoorOf100x200() {

        WoodenDoor door = DoorFactory.MakeDoor(100, 200);

        assertTrue(door.getWidth() == 100);
        assertTrue(door.getHeight() == 200);
    }

    @Test
    public void shouldCreateDoorOf50x100() {

        WoodenDoor door = DoorFactory.MakeDoor(50, 100);

        assertTrue(door.getWidth() == 50);
        assertTrue(door.getHeight() == 100);
    }
}
