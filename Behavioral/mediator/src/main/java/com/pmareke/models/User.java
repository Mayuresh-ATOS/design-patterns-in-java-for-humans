package com.pmareke.models;

import com.pmareke.interfaces.ChatRoomMediator;

public class User {
    protected String name;
    protected ChatRoomMediator chatMediator;

    public User(String name, ChatRoomMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return this.name;
    }

    public void send(String message) {
        this.chatMediator.showMessage(this, message);
    }
}
