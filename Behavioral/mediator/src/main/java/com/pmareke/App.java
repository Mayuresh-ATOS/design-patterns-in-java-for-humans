package com.pmareke;

import com.pmareke.models.ChatRoom;
import com.pmareke.models.User;

public class App {
    public static void main(String[] args) {
        ChatRoom mediator = new ChatRoom();

        User john = new User("John Doe", mediator);
        User jane = new User("Jane Doe", mediator);

        john.send("Hi there!");
        jane.send("Hey!");

        // Output will be
        // Feb 14, 10:58 [John]: Hi there!
        // Feb 14, 10:58 [Jane]: Hey!
    }
}
