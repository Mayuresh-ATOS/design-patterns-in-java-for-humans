package com.pmareke;

import com.pmareke.models.Hunter;
import com.pmareke.models.WildDog;
import com.pmareke.models.WildDogAdapter;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        WildDog wildDog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);

        Hunter hunter = new Hunter();
        Assert.assertTrue(hunter.hunt(wildDogAdapter).equals("Bark"));
    }
}
