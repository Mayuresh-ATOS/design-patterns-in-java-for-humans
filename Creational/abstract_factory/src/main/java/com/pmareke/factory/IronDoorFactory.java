package com.pmareke.factory;

import com.pmareke.interfaces.IDoor;
import com.pmareke.interfaces.IDoorFactory;
import com.pmareke.interfaces.IDoorFittingExpert;
import com.pmareke.models.IronDoor;
import com.pmareke.models.Welder;

public class IronDoorFactory implements IDoorFactory {
    @Override
    public IDoor MakeDoor() {
        return new IronDoor();
    }

    @Override
    public IDoorFittingExpert MakeFittingExpert() {
        return new Welder();
    }
}
