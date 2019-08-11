package com.pmareke;

import com.pmareke.models.LabDoor;
import com.pmareke.models.SecuredDoor;

public class App {
    public static void main(String[] args) {
        SecuredDoor door = new SecuredDoor(new LabDoor());
        System.out.println(door.open("invalid")); // Big no! It ain't possible.

        System.out.println(door.open("$ecr@t")); // Opening lab door
        System.out.println(door.close()); // Closing lab door
    }
}
