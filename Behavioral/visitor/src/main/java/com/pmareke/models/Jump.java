package com.pmareke.models;

import com.pmareke.interfaces.AnimalOperation;

public class Jump implements AnimalOperation {
    @Override
    public String visitMonkey(Monkey monkey) {
        return "Jumped 20 feet high! on to the tree!";
    }

    @Override
    public String visitLion(Lion lion) {
        return "Jumped 7 feet! Back on the ground!";
    }

    @Override
    public String visitDolphin(Dolphin dolphin) {
        return "Walked on water a little and disappeared";
    }
}
