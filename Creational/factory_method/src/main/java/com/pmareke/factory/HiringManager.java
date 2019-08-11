package com.pmareke.factory;

import com.pmareke.interfaces.IInterviewer;

public abstract class HiringManager {
    // Factory method
    abstract protected IInterviewer MakeInterviewer();

    public String TakeInterview() {
        IInterviewer interviewer = MakeInterviewer();
        return interviewer.AskQuestions();
    }
}
