package com.pmareke.factory;

import com.pmareke.interfaces.IInterviewer;
import com.pmareke.models.CommunityExecutive;

public class MarketingManager extends HiringManager {
    @Override
    protected IInterviewer MakeInterviewer() {
        return new CommunityExecutive();
    }
}
