package org.javaSchool;

import org.javaSchool.model.trainIndustry.comparators.TrainPassengersNumComparator;
import org.javaSchool.util.Constants;
import org.javaSchool.util.Parser;

import org.javaSchool.model.trainIndustry.PassengerTrain;

import java.util.*;

public class SortingDemo {

    public void addToOrderedCollection() {
        Parser parser = new Parser();
        List<PassengerTrain> passengerTrains = parser.parseVehicle(PassengerTrain.class, Constants.PASSENGER_TRAINS_PATH);
        Set<PassengerTrain> set = new TreeSet<>();
        for (PassengerTrain train : passengerTrains) {
            set.add(train);
        }
    }

    public void addToMap() {
        Parser parser = new Parser();
        List<PassengerTrain> passengerTrains = parser.parseVehicle(PassengerTrain.class, Constants.PASSENGER_TRAINS_PATH);
        Map<PassengerTrain, Integer> map = new HashMap<>();
        for (PassengerTrain train : passengerTrains) {
            map.put(train, 1);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(passengerTrains.get(i))) {
                System.out.println("Yeah, It contains: " + passengerTrains.get(i));
            }
        }
    }

    public void sortTrains() {
        Parser parser = new Parser();
        List<PassengerTrain> passengerTrains = parser.parseVehicle(PassengerTrain.class, Constants.PASSENGER_TRAINS_PATH);
        System.out.println("Printe before sort!");
        passengerTrains.stream().forEach(System.out::println);
//        Collections.sort(passengerTrains, new TrainPassengersNumComparator());
        System.out.println("Print after sort!");
        passengerTrains.stream().sorted(new TrainPassengersNumComparator()).forEach(System.out::println);
    }
}
