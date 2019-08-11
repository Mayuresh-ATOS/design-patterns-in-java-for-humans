package com.pmareke.models;

import com.pmareke.interfaces.Lion;

public class AfricanLion implements Lion {
    @Override
    public String roar() {
        return "Roar!";
    }
}