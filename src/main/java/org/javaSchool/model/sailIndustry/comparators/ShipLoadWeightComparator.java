package org.javaSchool.model.sailIndustry.comparators;

import org.javaSchool.model.sailIndustry.CargoShip;

import java.util.Comparator;

public class ShipLoadWeightComparator implements Comparator<CargoShip> {
    @Override
    public int compare(CargoShip o1, CargoShip o2) {
        return o1.getLoadWeight() - o2.getLoadWeight();
    }
}
