package com.pmareke.models;

import com.pmareke.interfaces.IInterviewer;

public class CommunityExecutive implements IInterviewer {
    @Override
    public String AskQuestions() {
        return "Asking about community building";
    }
}
