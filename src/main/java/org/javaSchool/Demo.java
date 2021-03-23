package org.javaSchool;

import org.javaSchool.model.Route;
import org.javaSchool.model.airlineIndustry.CargoAirCraft;
import org.javaSchool.model.airlineIndustry.PassengerAircraft;
import org.javaSchool.model.sailIndustry.CargoShip;
import org.javaSchool.model.trainIndustry.CargoTrain;
import org.javaSchool.model.sailIndustry.PassengerShip;
import org.javaSchool.model.trainIndustry.PassengerTrain;
import org.javaSchool.util.Parser;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.demoShips();
//        demo.demoAirCrafts();
//        demo.demoTrains();
        ParkingDemo parkingDemo = new ParkingDemo();
        parkingDemo.demoAircraftParking();
        parkingDemo.demoShipParking();
        parkingDemo.demoTrainParking();
    }

    public void demoTrains() {
        //Demonstrate a passenger train
        PassengerTrain passengerTrain = Parser.parsePassengerTrains().get(1);
        passengerTrain.embarkPassengers(10);
        passengerTrain.setRoute(new Route(List.of("Sofia", "Plovdiv", "Varna"), 600.10f));
        passengerTrain.travel();
        passengerTrain.endTravel();

        //Demonstrate a cargo train
        CargoTrain cargoTrain = Parser.parseCargoTrains().get(0);
        cargoTrain.load(100);
        cargoTrain.setRoute(new Route(List.of("Varna", "Plovdiv"), 400f));
        cargoTrain.travel();
        cargoTrain.endTravel();
    }

    public void demoShips() {
        //Demonstrate a passenger ship
        PassengerShip passengerShip = Parser.parsePassengerShips().get(0);
        passengerShip.embarkPassengers(120);
        passengerShip.setRoute(new Route(List.of("Varna", "Rotterdam"), 3000f));
        passengerShip.travel();
        passengerShip.endTravel();

        //Demonstrate a cargo ship
        CargoShip cargoShip = Parser.parseCargoShips().get(0);
        cargoShip.load(1000);
        cargoShip.setRoute(new Route(List.of("Burgas", "Antwerp"), 400f));
        cargoShip.travel();
        cargoShip.endTravel();
    }

    public void demoAirCrafts() {
        //Demonstrate a passenger plane
        PassengerAircraft passengerAircraft = Parser.parsePassengerAirCrafts().get(0);
        passengerAircraft.embarkPassengers(200);
        passengerAircraft.setRoute(new Route(List.of("Sofia", "Eindhoven"), 3000f));
        passengerAircraft.travel();
        passengerAircraft.endTravel();

        //Demonstrate a cargo plane
        CargoAirCraft cargoAirCraft = Parser.parseCargoAirCrafts().get(0);
        cargoAirCraft.load(1200);
        cargoAirCraft.setRoute(new Route(List.of("Sofia", "Eindhoven"), 3000f));
        cargoAirCraft.travel();
        cargoAirCraft.endTravel();
    }
}
