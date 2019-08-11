package com.pmareke.models;

import com.pmareke.interfaces.IInterviewer;

public class Developer implements IInterviewer {
    @Override
    public String AskQuestions() {
        return "Asking about design patterns!";
    }
}
