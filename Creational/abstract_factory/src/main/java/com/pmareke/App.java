package com.pmareke;

import com.pmareke.factory.IronDoorFactory;
import com.pmareke.factory.WoodenDoorFactory;
import com.pmareke.interfaces.IDoor;
import com.pmareke.interfaces.IDoorFittingExpert;

public class App {
    public static void main(String[] args) {
        WoodenDoorFactory woodenFactory = new WoodenDoorFactory();

        IDoor door = woodenFactory.MakeDoor();
        IDoorFittingExpert expert = woodenFactory.MakeFittingExpert();

        System.out.println(door.GetDescription()); // Output: I am a wooden door
        System.out.println(expert.GetDescription()); // Output: I can only fit wooden doors

        // Same for Iron Factory
        IronDoorFactory ironFactory = new IronDoorFactory();

        door = ironFactory.MakeDoor();
        expert = ironFactory.MakeFittingExpert();

        System.out.println(door.GetDescription()); // Output: I am an iron door
        System.out.println(expert.GetDescription()); // Output: I can only fit iron doors
    }
}
