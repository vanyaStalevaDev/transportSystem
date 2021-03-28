package org.javaSchool.service.parkingService;

import org.javaSchool.model.Vehicle;
import org.javaSchool.model.parking.Parking;
import org.javaSchool.model.parking.ParkingReceipt;
import java.time.Duration;
import java.time.LocalDateTime;


public class ParkingService {
    private Parking parking = new Parking();

    public void parkVehicle(Vehicle vehicle) {
        //if parking returns -1 for the parking space it means that the parking is full
        int parkingSpace = parking.parkVehicle(vehicle);
        if(parkingSpace==-1){
            System.out.println("The parking is full. The " + vehicle.getVehicleType() + "can not be parked!");
            return;
        }
        ParkingReceipt receipt = new ParkingReceipt();
        LocalDateTime arrivalTime = LocalDateTime.now();
        receipt.setArrivalTime(arrivalTime);
        receipt.setRegistrationPlate(vehicle.getPlateNumber());
        receipt.setParkingSpace(parkingSpace);
        vehicle.setParkingReceipt(receipt);
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
    }

    public double calculateCost(ParkingReceipt receipt) {
        Duration duration = Duration.between(receipt.getArrivalTime(), receipt.getExitTime());
        long hours = duration.toHours();
        double cost = hours * parking.getHourlyParkingRate();
        return cost;
    }
}
