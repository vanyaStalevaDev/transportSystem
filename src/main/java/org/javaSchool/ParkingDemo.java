package org.javaSchool;

import org.javaSchool.model.airlineIndustry.CargoAirCraft;
import org.javaSchool.model.parking.ParkingReceipt;
import org.javaSchool.model.sailIndustry.PassengerShip;
import org.javaSchool.model.trainIndustry.PassengerTrain;
import org.javaSchool.service.parkingService.ParkingService;
import org.javaSchool.util.Parser;

public class ParkingDemo {

    public void demoTrainParking() {
        PassengerTrain passengerTrain = Parser.parsePassengerTrains().get(1);
        ParkingService parkingService = new ParkingService();
        ParkingReceipt receipt = parkingService.parkVehicle(passengerTrain);
        passengerTrain.setParkingReceipt(receipt);
        parkingService.unparkVehicle(passengerTrain, 2);
    }

    public void demoShipParking() {
        PassengerShip passengerShip = Parser.parsePassengerShips().get(0);
        ParkingService parkingService = new ParkingService();
        ParkingReceipt receipt = parkingService.parkVehicle(passengerShip);
        passengerShip.setParkingReceipt(receipt);

        parkingService.unparkVehicle(passengerShip, 3);
    }

    public void demoAircraftParking() {
        CargoAirCraft cargoAirCraft = Parser.parseCargoAirCrafts().get(0);
        ParkingService parkingService = new ParkingService();
        ParkingReceipt receipt = parkingService.parkVehicle(cargoAirCraft);
        cargoAirCraft.setParkingReceipt(receipt);
        parkingService.unparkVehicle(cargoAirCraft, 5);
    }
}
