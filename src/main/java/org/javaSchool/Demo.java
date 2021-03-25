package org.javaSchool;

import org.javaSchool.model.Route;
import org.javaSchool.model.airlineIndustry.CargoAirCraft;
import org.javaSchool.model.airlineIndustry.PassengerAircraft;
import org.javaSchool.model.sailIndustry.CargoShip;
import org.javaSchool.model.trainIndustry.CargoTrain;
import org.javaSchool.model.sailIndustry.PassengerShip;
import org.javaSchool.model.trainIndustry.PassengerTrain;
import org.javaSchool.util.Constants;
import org.javaSchool.util.Parser;

import java.util.List;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
//      Demo demo = new Demo();
        SortingDemo demo = new SortingDemo();
        demo.sortTrains();
//        demo.addToMap();
//      demo.demoShips();
//      demo.demoAircrafts();
//      demo.demoTrains();
//      ParkingDemo parkingDemo = new ParkingDemo();
//      parkingDemo.demoAircraftParking();
//      parkingDemo.demoShipParking();
//      parkingDemo.demoTrainParking();
    }

    public void demoTrains() {
        //Demonstrate a passenger train
        Parser<PassengerTrain> parser = new Parser<>();
        PassengerTrain passengerTrain = parser.parseVehicle(PassengerTrain.class, Constants.PASSENGER_TRAINS_PATH).get(0);
//        PassengerTrain passengerTrain = Parser.parsePassengerTrains().get(1);
        passengerTrain.embarkPassengers(10);
        passengerTrain.setRoute(new Route(List.of("Sofia", "Plovdiv", "Varna"), 600.10f));
        passengerTrain.travel();
        passengerTrain.endTravel();

        //Demonstrate a cargo train
        Parser<CargoTrain> parser1 = new Parser<>();
        CargoTrain cargoTrain = parser1.parseVehicle(CargoTrain.class, Constants.CARGO_TRAINS_PATH).get(0);
        cargoTrain.load(100);
        cargoTrain.setRoute(new Route(List.of("Varna", "Plovdiv"), 400f));
        cargoTrain.travel();
        cargoTrain.endTravel();
    }

    public void demoShips() {
        //Demonstrate a passenger ship
        Parser<PassengerShip> parser = new Parser<>();
        PassengerShip passengerShip = parser.parseVehicle(PassengerShip.class, Constants.PASSENGER_SHIPS_PATH).get(0);
        passengerShip.embarkPassengers(120);
        passengerShip.setRoute(new Route(List.of("Varna", "Rotterdam"), 3000f));
        passengerShip.travel();
        passengerShip.endTravel();

        //Demonstrate a cargo ship
        Parser<CargoShip> parser1 = new Parser<>();
        CargoShip cargoShip = (CargoShip) parser1.parseVehicle(CargoShip.class, Constants.CARGO_SHIPS_PATH).get(0);
        cargoShip.load(1000);
        cargoShip.setRoute(new Route(List.of("Burgas", "Antwerp"), 400f));
        cargoShip.travel();
        cargoShip.endTravel();
    }

    public void demoAircrafts() {
        //Demonstrate a passenger plane
        Parser<PassengerAircraft> parser = new Parser<>();
        PassengerAircraft passengerAircraft = parser.parseVehicle(PassengerAircraft.class, Constants.PASSENGER_PLANES_PATH).get(0);
        passengerAircraft.embarkPassengers(200);
        passengerAircraft.setRoute(new Route(List.of("Sofia", "Eindhoven"), 3000f));
        passengerAircraft.travel();
        passengerAircraft.endTravel();

        //Demonstrate a cargo plane
        Parser<CargoAirCraft> parser1 = new Parser<>();
        CargoAirCraft cargoAirCraft = parser1.parseVehicle(CargoAirCraft.class, Constants.CARGO_PLANES_PATH).get(0);
        cargoAirCraft.load(1200);
        cargoAirCraft.setRoute(new Route(List.of("Sofia", "Eindhoven"), 3000f));
        cargoAirCraft.travel();
        cargoAirCraft.endTravel();
    }
}
