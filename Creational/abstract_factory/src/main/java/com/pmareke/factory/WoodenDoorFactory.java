package com.pmareke.factory;

import com.pmareke.interfaces.IDoor;
import com.pmareke.interfaces.IDoorFactory;
import com.pmareke.interfaces.IDoorFittingExpert;
import com.pmareke.models.Carpenter;
import com.pmareke.models.WoodenDoor;

public class WoodenDoorFactory implements IDoorFactory {
    @Override
    public IDoor MakeDoor() {
        return new WoodenDoor();
    }

    @Override
    public IDoorFittingExpert MakeFittingExpert() {
        return new Carpenter();
    }
}
