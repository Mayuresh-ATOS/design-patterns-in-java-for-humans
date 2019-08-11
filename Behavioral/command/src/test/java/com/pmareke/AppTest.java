package com.pmareke;

import com.pmareke.models.Bulb;
import com.pmareke.models.RemoteControl;
import com.pmareke.models.TurnOff;
import com.pmareke.models.TurnOn;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        Bulb bulb = new Bulb();

        TurnOn turnOn = new TurnOn(bulb);
        TurnOff turnOff = new TurnOff(bulb);

        RemoteControl remote = new RemoteControl();

        assertTrue(remote.submit(turnOn).equals("Bulb has been lit!"));
        assertTrue(remote.submit(turnOff).equals("Darkness!"));
    }
}
