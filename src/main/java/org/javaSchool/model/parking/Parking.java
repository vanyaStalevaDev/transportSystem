package org.javaSchool.model.parking;

import org.javaSchool.model.airlineIndustry.Aircraft;
import org.javaSchool.model.sailIndustry.Ship;
import org.javaSchool.model.trainIndustry.Train;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    public static final double HOURLY_PARKING_RATE = 1.5;
    public static List<Train> trainsParking = new ArrayList<>();
    public static List<Ship> shipsParking = new ArrayList<>();
    public static List<Aircraft> aircraftsParking = new ArrayList<>();
}
