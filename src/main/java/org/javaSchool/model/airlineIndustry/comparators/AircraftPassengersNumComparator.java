package org.javaSchool.model.airlineIndustry.comparators;

import org.javaSchool.model.airlineIndustry.PassengerAircraft;

import java.util.Comparator;

public class AircraftPassengersNumComparator implements Comparator<PassengerAircraft> {
    @Override
    public int compare(PassengerAircraft o1, PassengerAircraft o2) {
        return o1.getPassengersNumber() - o2.getPassengersNumber();
    }
}
