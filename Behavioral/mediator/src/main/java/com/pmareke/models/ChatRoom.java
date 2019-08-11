package com.pmareke.models;

import com.pmareke.interfaces.ChatRoomMediator;

import java.util.Date;

public class ChatRoom implements ChatRoomMediator {
    @Override
    public void showMessage(User user, String message) {
        Date time = new Date();
        String sender = user.getName();

        System.out.println(String.format("%s [ %s} ]: %s", time, sender, message));
    }
}
