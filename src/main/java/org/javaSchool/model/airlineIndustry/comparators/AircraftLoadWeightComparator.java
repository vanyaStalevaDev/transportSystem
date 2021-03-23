package org.javaSchool.model.airlineIndustry.comparators;

import org.javaSchool.model.airlineIndustry.CargoAirCraft;

import java.util.Comparator;

public class AircraftLoadWeightComparator implements Comparator<CargoAirCraft> {
    @Override
    public int compare(CargoAirCraft o1, CargoAirCraft o2) {
        return o1.getLoadWeight() - o2.getLoadWeight();
    }
}
