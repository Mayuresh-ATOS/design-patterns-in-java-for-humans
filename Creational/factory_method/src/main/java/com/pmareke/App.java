package com.pmareke;

import com.pmareke.factory.DevelopmentManager;
import com.pmareke.factory.MarketingManager;

public class App {
    public static void main(String[] args) {
        DevelopmentManager devManager = new DevelopmentManager();
        System.out.println(devManager.TakeInterview()); // Output: Asking about design patterns

        MarketingManager marketingManager = new MarketingManager();
        System.out.println(marketingManager.TakeInterview()); // Output: Asking about community building.
    }
}
