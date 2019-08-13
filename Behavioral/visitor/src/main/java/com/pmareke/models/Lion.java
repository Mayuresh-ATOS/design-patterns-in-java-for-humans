package com.pmareke.models;

import com.pmareke.interfaces.Animal;
import com.pmareke.interfaces.AnimalOperation;

public class Lion implements Animal {
    public String roar() {
        return "Roaaar!";
    }

    @Override
    public String accept(AnimalOperation operation) {
        return operation.visitLion(this);
    }
}