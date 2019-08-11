package com.pmareke.models;

import com.pmareke.interfaces.IDoorFittingExpert;

public class Welder implements IDoorFittingExpert {
    @Override
    public String GetDescription() {
        return "I can only fit iron doors";
    }
}