package com.pmareke;

import com.pmareke.interfaces.Iterator;
import com.pmareke.models.RadioStation;
import com.pmareke.models.StationList;

public class App {
    public static void main(String[] args) {
        StationList stationList = new StationList();

        stationList.AddStation(new RadioStation(89));
        stationList.AddStation(new RadioStation(101));
        stationList.AddStation(new RadioStation(102));
        stationList.AddStation(new RadioStation(103.2));

        for (Iterator iter = stationList.getIterator(); iter.hasNext(); ) {
            RadioStation radio = (RadioStation) iter.next();
            System.out.println(radio.getFrequency());
        }

        stationList.RemoveStation(new RadioStation(89)); // Will remove station 89
    }
}
