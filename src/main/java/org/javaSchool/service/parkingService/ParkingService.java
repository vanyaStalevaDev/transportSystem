package org.javaSchool.service.parkingService;

import org.javaSchool.model.Vehicle;
import org.javaSchool.model.VehicleType;
import org.javaSchool.model.airlineIndustry.Aircraft;
import org.javaSchool.model.parking.Parking;
import org.javaSchool.model.parking.ParkingReceipt;
import org.javaSchool.model.sailIndustry.Ship;
import org.javaSchool.model.trainIndustry.Train;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.prefs.PreferenceChangeEvent;


public class ParkingService {
    private Parking parking = new Parking();

    public ParkingReceipt parkVehicle(Vehicle vehicle) {
        int parkingSpace = parking.parkVehicle(vehicle);
        ParkingReceipt receipt = new ParkingReceipt();
        LocalDateTime arrivalTime = LocalDateTime.now();
        receipt.setArrivalTime(arrivalTime);
        receipt.setRegistrationPlate(vehicle.getPlateNumber());
        receipt.setParkingSpace(parkingSpace);
        return receipt;
    }

    public void unparkVehicle(Vehicle vehicle, int passingHours) {
        LocalDateTime exitTime = LocalDateTime.now();
        ParkingReceipt receipt = vehicle.getParkingReceipt();
        int space = receipt.getParkingSpace();
        parking.unparkVehicle(vehicle, space);
        //simulate hours passing during parking
        receipt.setExitTime(exitTime.plusHours(passingHours));
        double cost = calculateCost(receipt);
        receipt.setCost(cost);
        System.out.println(receipt);
        vehicle.setParkingReceipt(null);
//        if (vehicle instanceof Train) {
//            if (!parking.trainsParking.isEmpty() && parking.trainsParking.contains(vehicle)) {
//                parking.trainsParking.remove((Train) vehicle);
//            }
//
//        } else if (vehicle instanceof Ship) {
//            if (!parking.shipsParking.isEmpty() && parking.shipsParking.contains(vehicle)) {
//                parking.shipsParking.remove((Ship) vehicle);
//            }
//        } else if (vehicle instanceof Aircraft) {
//            if (!parking.aircraftsParking.isEmpty() && parking.aircraftsParking.contains(vehicle)) {
//                parking.aircraftsParking.remove((Ship) vehicle);
//            }
//        }

    }

    public double calculateCost(ParkingReceipt receipt) {
        Duration duration = Duration.between(receipt.getArrivalTime(), receipt.getExitTime());
        long hours = duration.toHours();
        double cost = hours * parking.getHourlyParkingRate();
        return cost;
    }
}
