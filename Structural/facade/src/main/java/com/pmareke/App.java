package com.pmareke;

import com.pmareke.facades.ComputerFacade;
import com.pmareke.models.Computer;

public class App {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade(new Computer());
        computer.turnOn(); // Ouch! Beep beep! Loading.. Ready to be used!
        computer.turnOff(); // Bup bup buzzz! Haah! Zzzzz
    }
}