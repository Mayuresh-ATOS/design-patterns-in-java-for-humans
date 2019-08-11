package com.pmareke;

import com.pmareke.facades.ComputerFacade;
import com.pmareke.models.Computer;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void shouldAnswerWithTurnOn() {
        Computer computer = mock(Computer.class);

        doNothing().when(computer).getElectricShock();
        doNothing().when(computer).showLoadingScreen();
        doNothing().when(computer).getElectricShock();
        doNothing().when(computer).bam();

        ComputerFacade computerFacade = new ComputerFacade(computer);
        computerFacade.turnOn();

        verify(computer, times(1)).getElectricShock();
        verify(computer, times(1)).showLoadingScreen();
        verify(computer, times(1)).getElectricShock();
        verify(computer, times(1)).bam();
    }

    @Test
    public void shouldAnswerWithTurnOff() {
        Computer computer = mock(Computer.class);

        doNothing().when(computer).closeEverything();
        doNothing().when(computer).pullCurrent();
        doNothing().when(computer).sooth();

        ComputerFacade computerFacade = new ComputerFacade(computer);
        computerFacade.turnOff();

        verify(computer, times(1)).closeEverything();
        verify(computer, times(1)).pullCurrent();
        verify(computer, times(1)).sooth();
    }
}
