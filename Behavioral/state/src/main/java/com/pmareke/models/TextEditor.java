package com.pmareke.models;

import com.pmareke.interfaces.WritingState;

public class TextEditor {
    protected WritingState state;

    public TextEditor(WritingState state) {
        this.state = state;
    }

    public void setState(WritingState state) {
        this.state = state;
    }

    public String type(String words) {
        return this.state.write(words);
    }
}
