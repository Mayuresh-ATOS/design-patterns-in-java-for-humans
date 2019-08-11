package com.pmareke;

import com.pmareke.factory.DevelopmentManager;
import com.pmareke.factory.MarketingManager;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithDevelopmentManagerAnswer() {
        DevelopmentManager devManager = new DevelopmentManager();
        assertTrue(devManager.TakeInterview().equals("Asking about design patterns!"));
    }

    @Test
    public void shouldAnswerWithMarketingManagerAnswer() {
        MarketingManager marketingManager = new MarketingManager();
        assertTrue(marketingManager.TakeInterview().equals("Asking about community building"));
    }
}
