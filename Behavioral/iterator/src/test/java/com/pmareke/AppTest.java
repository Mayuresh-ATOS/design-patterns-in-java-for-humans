package com.pmareke;

import com.pmareke.interfaces.Iterator;
import com.pmareke.models.RadioStation;
import com.pmareke.models.StationList;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {

        StationList stationList = new StationList();

        stationList.AddStation(new RadioStation(89));
        stationList.AddStation(new RadioStation(101));
        stationList.AddStation(new RadioStation(102));
        stationList.AddStation(new RadioStation(103.2));

        Iterator iter = stationList.getIterator();
        RadioStation radio = (RadioStation) iter.next();
        assertTrue(radio.getFrequency() == 89);

        radio = (RadioStation) iter.next();
        assertTrue(radio.getFrequency() == 101);

        radio = (RadioStation) iter.next();
        assertTrue(radio.getFrequency() == 102);

        radio = (RadioStation) iter.next();
        assertTrue(radio.getFrequency() == 103.2);

        radio = (RadioStation) iter.next();
        assertTrue(radio == null);
    }
}
