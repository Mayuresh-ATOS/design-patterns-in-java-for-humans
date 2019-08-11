package com.pmareke.models;

import com.pmareke.interfaces.Command;

public class TurnOff implements Command {
    protected Bulb bulb;

    public TurnOff(Bulb bulb) {
        this.bulb = bulb;
    }

    public String execute() {
        return this.bulb.turnOff();
    }

    public String undo() {
        return this.bulb.turnOn();
    }

    public String redo() {
        return this.bulb.turnOff();
    }
}