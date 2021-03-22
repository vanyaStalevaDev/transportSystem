package org.javaSchool.util;

import com.opencsv.bean.CsvToBeanBuilder;
import org.javaSchool.model.trainIndustry.CargoTrain;
import org.javaSchool.model.trainIndustry.PassengerTrain;
import org.javaSchool.model.sailIndustry.CargoShip;
import org.javaSchool.model.sailIndustry.PassengerShip;
import org.javaSchool.model.airlineIndustry.CargoAirCraft;
import org.javaSchool.model.airlineIndustry.PassengerAircraft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class Parser {

    public static List<PassengerTrain> parsePassengerTrains() {
        List<PassengerTrain> passengerTrains = Collections.EMPTY_LIST;
        try {
            passengerTrains = new CsvToBeanBuilder<PassengerTrain>(new FileReader(Constants.USER_DIR + Constants.PASSENGER_TRAINS_PATH))
                    .withType(PassengerTrain.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengerTrains;
    }

    public static List<CargoTrain> parseCargoTrains() {
        List<CargoTrain> cargoTrains = Collections.EMPTY_LIST;
        try {
            cargoTrains = new CsvToBeanBuilder<CargoTrain>(new FileReader(Constants.USER_DIR + Constants.CARGO_TRAINS_PATH))
                    .withType(CargoTrain.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cargoTrains;
    }


    public static List<PassengerAircraft> parsePassengerAirCrafts() {
        List<PassengerAircraft> passengerAirCrafts = Collections.EMPTY_LIST;
        try {
            passengerAirCrafts = new CsvToBeanBuilder<PassengerAircraft>(new FileReader(Constants.USER_DIR + Constants.PASSENGER_PLANES_PATH))
                    .withType(PassengerAircraft.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengerAirCrafts;
    }

    public static List<CargoAirCraft> parseCargoAirCrafts() {
        List<CargoAirCraft> cargoAirCrafts = Collections.EMPTY_LIST;
        try {
            cargoAirCrafts = new CsvToBeanBuilder<CargoAirCraft>(new FileReader(Constants.USER_DIR + Constants.CARGO_PLANES_PATH))
                    .withType(CargoAirCraft.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cargoAirCrafts;
    }


    public static List<PassengerShip> parsePassengerShips() {
        List<PassengerShip> passengerShips = Collections.EMPTY_LIST;
        try {
            passengerShips = new CsvToBeanBuilder<PassengerShip>(new FileReader(Constants.USER_DIR + Constants.PASSENGER_SHIPS_PATH))
                    .withType(PassengerShip.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengerShips;
    }

    public static List<CargoShip> parseCargoShips() {
        List<CargoShip> cargoShips = Collections.EMPTY_LIST;
        try {
            cargoShips = new CsvToBeanBuilder<CargoShip>(new FileReader(Constants.USER_DIR + Constants.CARGO_SHIPS_PATH))
                    .withType(CargoShip.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cargoShips;
    }
}
