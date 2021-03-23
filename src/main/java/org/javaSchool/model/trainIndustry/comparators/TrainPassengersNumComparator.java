package org.javaSchool.model.trainIndustry.comparators;

import org.javaSchool.model.trainIndustry.PassengerTrain;

import java.util.Comparator;

public class TrainPassengersNumComparator implements Comparator<PassengerTrain> {
    @Override
    public int compare(PassengerTrain o1, PassengerTrain o2) {
        return o1.getPassengersNumber() - o2.getPassengersNumber();
    }
}
