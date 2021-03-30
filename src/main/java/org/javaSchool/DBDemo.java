package org.javaSchool;

import org.javaSchool.model.airlineIndustry.CargoAircraft;
import org.javaSchool.model.airlineIndustry.PassengerAircraft;
import org.javaSchool.model.sailIndustry.CargoShip;
import org.javaSchool.model.sailIndustry.PassengerShip;
import org.javaSchool.model.trainIndustry.CargoTrain;
import org.javaSchool.model.trainIndustry.PassengerTrain;
import org.javaSchool.util.Constants;
import org.javaSchool.util.Parser;

import java.sql.*;
import java.util.List;

public class DBDemo {

    public void saveCargoTrains() {
        Parser<CargoTrain> parser = new Parser<>();
        List<CargoTrain> cargoTrains = parser.parseVehicle(CargoTrain.class, Constants.CARGO_TRAINS_PATH);
        Connection con = getConnection();
        List<Object> cargoTrainValues = null;
        String insertQuery = "INSERT INTO `transport_system`.`cargo_train` (plate_number, engine_type, load_weight, load_capacity) values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(insertQuery);
            for (CargoTrain cargoTrain : cargoTrains) {
                cargoTrainValues = List.of(cargoTrain.getPlateNumber(), cargoTrain.getEngineType().toString(), cargoTrain.getLoadWeight(), cargoTrain.getLoadCapacity());

                for (int j = 1; j <= cargoTrainValues.size(); j++) {
                    prep.setObject(j, cargoTrainValues.get(j - 1));
                }
                prep.addBatch();
            }
            prep.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }


    public void savePassengerTrains() {
        Parser<PassengerTrain> parser = new Parser<>();
        List<PassengerTrain> passengerTrains = parser.parseVehicle(PassengerTrain.class, Constants.PASSENGER_TRAINS_PATH);
        Connection con = getConnection();
        List<Object> passengerTrainValues = null;
        String insertQuery = "INSERT INTO `transport_system`.`passenger_train` (plate_number, engine_type, passengers_number, capacity) values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(insertQuery);
            for (PassengerTrain passengerTrain : passengerTrains) {
                passengerTrainValues = List.of(passengerTrain.getPlateNumber(), passengerTrain.getEngineType().toString(), passengerTrain.getPassengersNumber(), passengerTrain.getCapacity());

                for (int j = 1; j <= passengerTrainValues.size(); j++) {
                    prep.setObject(j, passengerTrainValues.get(j - 1));
                }
                prep.addBatch();
            }
            prep.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void saveCargoShips() {
        Parser<CargoShip> parser = new Parser<>();
        List<CargoShip> cargoShips = parser.parseVehicle(CargoShip.class, Constants.CARGO_SHIPS_PATH);
        Connection con = getConnection();
        List<Object> cargoShipValues = null;
        String insertQuery = "INSERT INTO `transport_system`.`cargo_ship` (plate_number, engine_type, load_weight, load_capacity) values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(insertQuery);
            for (CargoShip cargoShip : cargoShips) {
                cargoShipValues = List.of(cargoShip.getPlateNumber(), cargoShip.getEngineType().toString(), cargoShip.getLoadWeight(), cargoShip.getLoadCapacity());

                for (int j = 1; j <= cargoShipValues.size(); j++) {
                    prep.setObject(j, cargoShipValues.get(j - 1));
                }
                prep.addBatch();
            }
            prep.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void savePassengerShips() {
        Parser<PassengerShip> parser = new Parser<>();
        List<PassengerShip> passengerShips = parser.parseVehicle(PassengerShip.class, Constants.PASSENGER_SHIPS_PATH);
        Connection con = getConnection();
        List<Object> passengerShipValues = null;
        String insertQuery = "INSERT INTO `transport_system`.`passenger_ship` (plate_number, engine_type, passengers_number, capacity) values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(insertQuery);
            for (PassengerShip passengerShip : passengerShips) {
                passengerShipValues = List.of(passengerShip.getPlateNumber(), passengerShip.getEngineType().toString(), passengerShip.getPassengersNumber(), passengerShip.getCapacity());

                for (int j = 1; j <= passengerShipValues.size(); j++) {
                    prep.setObject(j, passengerShipValues.get(j - 1));
                }
                prep.addBatch();
            }
            prep.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }


    public void saveCargoAircrafts() {
        Parser<CargoAircraft> parser = new Parser<>();
        List<CargoAircraft> cargoPlanes = parser.parseVehicle(CargoAircraft.class, Constants.CARGO_PLANES_PATH);
        Connection con = getConnection();
        List<Object> cargoPlaneValues = null;
        String insertQuery = "INSERT INTO `transport_system`.`cargo_aircraft` (plate_number, engine_type, load_weight, load_capacity) values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(insertQuery);
            for (CargoAircraft cargoAircraft : cargoPlanes) {
                cargoPlaneValues = List.of(cargoAircraft.getPlateNumber(), cargoAircraft.getEngineType().toString(), cargoAircraft.getLoadWeight(), cargoAircraft.getLoadCapacity());

                for (int j = 1; j <= cargoPlaneValues.size(); j++) {
                    prep.setObject(j, cargoPlaneValues.get(j - 1));
                }
                prep.addBatch();
            }
            prep.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void savePassengerAircrafts() {
        Parser<PassengerAircraft> parser = new Parser<>();
        List<PassengerAircraft> passengerAircrafts = parser.parseVehicle(PassengerAircraft.class, Constants.PASSENGER_PLANES_PATH);
        Connection con = getConnection();
        List<Object> passengerPlaneValues = null;
        String insertQuery = "INSERT INTO `transport_system`.`passenger_aircraft` (plate_number, engine_type, passengers_number, capacity) values(?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(insertQuery);
            for (PassengerAircraft passengerAircraft : passengerAircrafts) {
                passengerPlaneValues = List.of(passengerAircraft.getPlateNumber(), passengerAircraft.getEngineType().toString(), passengerAircraft.getPassengersNumber(), passengerAircraft.getCapacity());

                for (int j = 1; j <= passengerPlaneValues.size(); j++) {
                    prep.setObject(j, passengerPlaneValues.get(j - 1));
                }
                prep.addBatch();
            }
            prep.executeBatch();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_system", "test", "test123@");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return con;
    }


}
