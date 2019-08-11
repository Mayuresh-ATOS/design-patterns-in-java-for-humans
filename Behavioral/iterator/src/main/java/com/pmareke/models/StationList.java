package com.pmareke.models;

import com.pmareke.interfaces.Container;
import com.pmareke.interfaces.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationList implements Container {

    protected List<RadioStation> stations = new ArrayList<RadioStation>();

    public void AddStation(RadioStation station) {
        this.stations.add(station);
    }

    public void RemoveStation(final RadioStation toRemove) {
        this.stations = this.stations.stream()
                .filter(s -> s.frequency != toRemove.getFrequency())
                .collect(Collectors.toList());
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < stations.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return stations.get(index++);
            }
            return null;
        }
    }
}