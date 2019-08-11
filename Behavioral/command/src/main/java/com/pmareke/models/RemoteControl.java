package com.pmareke.models;

import com.pmareke.interfaces.Command;

public class RemoteControl {
    public String submit(Command command) {
        return command.execute();
    }
}
