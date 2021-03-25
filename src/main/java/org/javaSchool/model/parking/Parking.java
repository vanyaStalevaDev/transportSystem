package org.javaSchool.model.parking;

import org.javaSchool.model.Vehicle;
import org.javaSchool.model.VehicleType;
import org.javaSchool.model.airlineIndustry.Aircraft;
import org.javaSchool.model.sailIndustry.Ship;
import org.javaSchool.model.trainIndustry.Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private static final float HOURLY_PARKING_RATE = 1.5f;
    private static final int TRAIN_PARKING_CAPACITY = 50;
    private static final int SHIP_PARKING_CAPACITY = 20;
    private static final int AIRCRAFT_PARKING_CAPACITY = 20;

    private Train[] trainsParking = new Train[TRAIN_PARKING_CAPACITY];
    private Ship[] shipsParking = new Ship[SHIP_PARKING_CAPACITY];
    private Aircraft[] aircraftsParking = new Aircraft[AIRCRAFT_PARKING_CAPACITY];
    Map<VehicleType, Vehicle[]> parkingLots = new HashMap<>();

    public Parking() {
        parkingLots.put(VehicleType.AIRCRAFT, aircraftsParking);
        parkingLots.put(VehicleType.SHIP, shipsParking);
        parkingLots.put(VehicleType.TRAIN, trainsParking);

    }

    public Map<VehicleType, Vehicle[]> getParkingLots() {
        return parkingLots;
    }

    public int parkVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getVehicleType();
        Vehicle[] parking = parkingLots.get(type);
        int parkingSpace = findASpot(parking);
        parking[parkingSpace] = vehicle;
        return parkingSpace;
    }

    public void unparkVehicle(Vehicle vehicle, int parkingSpace) {
        VehicleType type = vehicle.getVehicleType();
        Vehicle[] parkingLot = parkingLots.get(type);
        parkingLot[parkingSpace] = null;
    }

    private int findASpot(Vehicle[] parking) {
        int parkingSpace = -1;
        for (int i = 0; i < parking.length; i++) {
            if (parking[i] != null) {
                continue;
            } else {
                parkingSpace = i;
                break;
            }
        }
        return parkingSpace;
    }

    public float getHourlyParkingRate() {
        return HOURLY_PARKING_RATE;
    }
}
