package com.pmareke.models;

import com.pmareke.interfaces.IDoor;

public class IronDoor implements IDoor {
    @Override
    public String GetDescription() {
        return "I am a iron door";
    }
}