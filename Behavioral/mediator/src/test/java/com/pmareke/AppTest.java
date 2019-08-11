package com.pmareke;

import com.pmareke.models.ChatRoom;
import com.pmareke.models.User;
import org.junit.Test;
import org.mockito.Matchers;

import static org.mockito.Mockito.*;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        ChatRoom mediator = mock(ChatRoom.class);
        doNothing().when(mediator)
                .showMessage(Matchers.isA(User.class), Matchers.isA(String.class));

        User john = new User("John Doe", mediator);
        User jane = new User("Jane Doe", mediator);

        john.send("Hi there!");
        jane.send("Hey!");

        verify(mediator, times(2))
                .showMessage(Matchers.isA(User.class), Matchers.isA(String.class));
    }
}
