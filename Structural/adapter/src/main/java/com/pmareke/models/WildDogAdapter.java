package com.pmareke.models;

import com.pmareke.interfaces.Lion;

public class WildDogAdapter implements Lion {

    protected WildDog dog;

    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    @Override
    public String roar() {
        return this.dog.bark();
    }
}
