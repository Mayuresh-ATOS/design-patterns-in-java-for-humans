package com.pmareke.interfaces;

import com.pmareke.models.User;

public interface ChatRoomMediator {
    void showMessage(User user, String message);
}
