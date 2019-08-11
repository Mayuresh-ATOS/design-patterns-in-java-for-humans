package com.pmareke.interfaces;

public interface Command {
    String execute();

    String undo();

    String redo();
}
