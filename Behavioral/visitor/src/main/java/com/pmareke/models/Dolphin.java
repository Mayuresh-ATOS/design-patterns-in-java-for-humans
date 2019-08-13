package com.pmareke.models;

import com.pmareke.interfaces.Animal;
import com.pmareke.interfaces.AnimalOperation;

public class Dolphin implements Animal {
    public String speak() {
        return "Tuut tuttu tuutt!";
    }

    @Override
    public String accept(AnimalOperation operation) {
        return operation.visitDolphin(this);
    }
}
