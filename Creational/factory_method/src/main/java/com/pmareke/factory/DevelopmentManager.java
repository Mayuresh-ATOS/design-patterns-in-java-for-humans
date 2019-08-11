package com.pmareke.factory;

import com.pmareke.interfaces.IInterviewer;
import com.pmareke.models.Developer;

public class DevelopmentManager extends HiringManager {
    @Override
    protected IInterviewer MakeInterviewer() {
        return new Developer();
    }
}
