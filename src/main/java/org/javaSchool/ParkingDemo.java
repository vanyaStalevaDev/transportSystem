package org.javaSchool;

import org.javaSchool.model.airlineIndustry.CargoAircraft;
import org.javaSchool.model.sailIndustry.PassengerShip;
import org.javaSchool.model.trainIndustry.PassengerTrain;
import org.javaSchool.service.parkingService.ParkingService;
import org.javaSchool.util.Constants;
import org.javaSchool.util.Parser;

public class ParkingDemo {

     public void demoTrainParking() {
        Parser<PassengerTrain> parser = new Parser<>();
        PassengerTrain passengerTrain = parser.parseVehicle(PassengerTrain.class, Constants.PASSENGER_TRAINS_PATH).get(1);
        ParkingService parkingService = new ParkingService();
        parkingService.parkVehicle(passengerTrain);
        parkingService.unparkVehicle(passengerTrain, 2);
    }

    public void demoShipParking() {
        Parser<PassengerShip> parser = new Parser<>();
        PassengerShip passengerShip = parser.parseVehicle(PassengerShip.class, Constants.PASSENGER_SHIPS_PATH).get(0);
        ParkingService parkingService = new ParkingService();
        parkingService.parkVehicle(passengerShip);
        parkingService.unparkVehicle(passengerShip, 3);
    }

    public void demoAircraftParking() {
        Parser<CargoAircraft> parser = new Parser<>();
        CargoAircraft cargoAirCraft = parser.parseVehicle(CargoAircraft.class, Constants.CARGO_PLANES_PATH).get(0);
        ParkingService parkingService = new ParkingService();
        parkingService.parkVehicle(cargoAirCraft);
        parkingService.unparkVehicle(cargoAirCraft, 5);
    }
}
