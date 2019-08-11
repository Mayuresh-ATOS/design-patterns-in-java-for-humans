package com.pmareke.models;

import com.pmareke.interfaces.IDoorFittingExpert;

public class Carpenter implements IDoorFittingExpert {
    @Override
    public String GetDescription() {
        return "I can only fit wooden doors";
    }
}
