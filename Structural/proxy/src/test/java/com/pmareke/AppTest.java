package com.pmareke;

import com.pmareke.models.LabDoor;
import com.pmareke.models.SecuredDoor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithInvalidPassword() {
        SecuredDoor door = new SecuredDoor(new LabDoor());
        assertTrue(door.open("invalid").equals("Big no! It ain't possible."));
        assertTrue(door.close().equals("Closing lab door"));
    }

    @Test
    public void shouldAnswerWithValidPassword() {
        SecuredDoor door = new SecuredDoor(new LabDoor());
        assertTrue(door.open("$ecr@t").equals("Opening lab door"));
        assertTrue(door.close().equals("Closing lab door"));
    }
}
