package com.pmareke.models;

import com.pmareke.interfaces.IDoor;

public class SecuredDoor {

    protected IDoor door;

    public SecuredDoor(IDoor door) {
        this.door = door;
    }

    public String open(String password) {
        return this.Authenticate(password) ? this.door.open() : "Big no! It ain't possible.";
    }

    public boolean Authenticate(String password) {
        return password == "$ecr@t";
    }

    public String close() {
        return this.door.close();
    }
}
