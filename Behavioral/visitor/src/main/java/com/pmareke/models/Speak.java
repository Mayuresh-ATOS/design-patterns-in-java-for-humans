package com.pmareke.models;

import com.pmareke.interfaces.AnimalOperation;

public class Speak implements AnimalOperation {
    @Override
    public String visitMonkey(Monkey monkey) {
        return monkey.shout();
    }

    @Override
    public String visitLion(Lion lion) {
        return lion.roar();
    }

    @Override
    public String visitDolphin(Dolphin dolphin) {
        return dolphin.speak();
    }
}
