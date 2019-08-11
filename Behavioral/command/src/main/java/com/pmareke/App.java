package com.pmareke;

import com.pmareke.models.Bulb;
import com.pmareke.models.RemoteControl;
import com.pmareke.models.TurnOff;
import com.pmareke.models.TurnOn;

public class App {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();

        TurnOn turnOn = new TurnOn(bulb);
        TurnOff turnOff = new TurnOff(bulb);

        RemoteControl remote = new RemoteControl();
        remote.submit(turnOn); // Bulb has been lit!
        remote.submit(turnOff); // Darkness!
    }
}
