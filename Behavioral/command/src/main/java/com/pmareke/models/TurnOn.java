package com.pmareke.models;

import com.pmareke.interfaces.Command;

public class TurnOn implements Command {
    protected Bulb bulb;

    public TurnOn(Bulb bulb) {
        this.bulb = bulb;
    }

    public String execute() {
        return this.bulb.turnOn();
    }

    public String undo() {
        return this.bulb.turnOff();
    }

    public String redo() {
        return this.bulb.turnOn();
    }
}