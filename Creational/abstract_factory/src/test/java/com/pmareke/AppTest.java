package com.pmareke;

import com.pmareke.factory.IronDoorFactory;
import com.pmareke.factory.WoodenDoorFactory;
import com.pmareke.interfaces.IDoor;
import com.pmareke.interfaces.IDoorFittingExpert;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithWoodenDoor() {
        WoodenDoorFactory woodenFactory = new WoodenDoorFactory();

        IDoor door = woodenFactory.MakeDoor();
        IDoorFittingExpert expert = woodenFactory.MakeFittingExpert();

        Assert.assertTrue(door.GetDescription().equals("I am a wooden door"));
        Assert.assertTrue(expert.GetDescription().equals("I can only fit wooden doors"));
    }

    @Test
    public void shouldAnswerWithIronDoor() {
        IronDoorFactory ironFactory = new IronDoorFactory();

        IDoor door = ironFactory.MakeDoor();
        IDoorFittingExpert expert = ironFactory.MakeFittingExpert();

        Assert.assertTrue(door.GetDescription().equals("I am a iron door"));
        Assert.assertTrue(expert.GetDescription().equals("I can only fit iron doors"));
    }
}
