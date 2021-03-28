package org.javaSchool.model.airlineIndustry.comparators;

import org.javaSchool.model.airlineIndustry.CargoAircraft;

import java.util.Comparator;

public class AircraftLoadWeightComparator implements Comparator<CargoAircraft> {
    @Override
    public int compare(CargoAircraft o1, CargoAircraft o2) {
        return o1.getLoadWeight() - o2.getLoadWeight();
    }
}
