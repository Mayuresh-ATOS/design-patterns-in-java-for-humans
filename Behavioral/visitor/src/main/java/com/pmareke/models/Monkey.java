package com.pmareke.models;

import com.pmareke.interfaces.Animal;
import com.pmareke.interfaces.AnimalOperation;

public class Monkey implements Animal {
    public String shout() {
        return "Ooh oo aa aa!";
    }

    @Override
    public String accept(AnimalOperation operation) {
        return operation.visitMonkey(this);
    }
}