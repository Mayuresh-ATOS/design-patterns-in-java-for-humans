package com.pmareke.models;

import com.pmareke.interfaces.IDoor;

public class LabDoor implements IDoor {
    @Override
    public String open() {
        return "Opening lab door";
    }

    @Override
    public String close() {
        return "Closing lab door";
    }
}
