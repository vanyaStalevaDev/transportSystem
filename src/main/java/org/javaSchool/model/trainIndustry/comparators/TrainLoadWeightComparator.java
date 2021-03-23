package org.javaSchool.model.trainIndustry.comparators;

import org.javaSchool.model.trainIndustry.CargoTrain;

import java.util.Comparator;

public class TrainLoadWeightComparator implements Comparator<CargoTrain> {
    @Override
    public int compare(CargoTrain o1, CargoTrain o2) {
        return o1.getLoadWeight() - o2.getLoadWeight();
    }
}
