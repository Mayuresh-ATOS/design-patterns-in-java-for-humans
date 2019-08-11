package com.pmareke.models;

import com.pmareke.interfaces.IDoor;

public class WoodenDoor implements IDoor {
    @Override
    public String GetDescription() {
        return "I am a wooden door";
    }
}
