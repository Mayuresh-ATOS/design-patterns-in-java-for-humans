package com.pmareke.models;

import com.pmareke.interfaces.WritingState;

public class LowerCase implements WritingState {
    @Override
    public String write(String words) {
        return words.toLowerCase();
    }
}
