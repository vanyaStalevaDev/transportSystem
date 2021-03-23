package org.javaSchool.service.parkingService;

import org.javaSchool.model.Vehicle;
import org.javaSchool.model.airlineIndustry.Aircraft;
import org.javaSchool.model.parking.Parking;
import org.javaSchool.model.parking.ParkingReceipt;
import org.javaSchool.model.sailIndustry.Ship;
import org.javaSchool.model.trainIndustry.Train;

import java.time.Duration;
import java.time.LocalDateTime;


public class ParkingService {

    public ParkingReceipt parkVehicle(Vehicle vehicle) {
        ParkingReceipt receipt = new ParkingReceipt();
        LocalDateTime arrivalTime = LocalDateTime.now();
        receipt.setArrivalTime(arrivalTime);
        receipt.setRegistrationPlate(vehicle.getPlateNumber());
        if (vehicle instanceof Train) {
            Parking.trainsParking.add((Train) vehicle);
        } else if (vehicle instanceof Ship) {
            Parking.shipsParking.add((Ship) vehicle);
        } else if (vehicle instanceof Aircraft) {
            Parking.aircraftsParking.add((Aircraft) vehicle);
        }
        return receipt;
    }

    public void unparkVehicle(Vehicle vehicle, int passingHours) {
        LocalDateTime exitTime = LocalDateTime.now();
        if (vehicle instanceof Train) {
            if (!Parking.trainsParking.isEmpty() && Parking.trainsParking.contains(vehicle)) {
                Parking.trainsParking.remove((Train) vehicle);
            }

        } else if (vehicle instanceof Ship) {
            if (!Parking.shipsParking.isEmpty() && Parking.shipsParking.contains(vehicle)) {
                Parking.shipsParking.remove((Ship) vehicle);
            }
        } else if (vehicle instanceof Aircraft) {
            if (!Parking.aircraftsParking.isEmpty() && Parking.aircraftsParking.contains(vehicle)) {
                Parking.aircraftsParking.remove((Ship) vehicle);
            }
        }


        ParkingReceipt receipt = vehicle.getParkingReceipt();
        //simulate hours passing during parking
        receipt.setExitTime(exitTime.plusHours(passingHours));

        double cost = calculateCost(receipt);
        receipt.setCost(cost);
        System.out.println(receipt);
        vehicle.setParkingReceipt(null);

    }

    public double calculateCost(ParkingReceipt receipt) {
        Duration duration = Duration.between(receipt.getArrivalTime(), receipt.getExitTime());
        long hours = duration.toHours();
        double cost = hours * Parking.HOURLY_PARKING_RATE;
        return cost;
    }
}
