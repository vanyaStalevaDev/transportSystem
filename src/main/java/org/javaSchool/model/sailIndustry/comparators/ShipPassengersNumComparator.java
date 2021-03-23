package org.javaSchool.model.sailIndustry.comparators;

import org.javaSchool.model.airlineIndustry.PassengerAircraft;
import org.javaSchool.model.sailIndustry.PassengerShip;

import java.util.Comparator;

public class ShipPassengersNumComparator implements Comparator<PassengerShip> {
    @Override
    public int compare(PassengerShip o1, PassengerShip o2) {
        return o1.getPassengersNumber() - o2.getPassengersNumber();
    }
}
