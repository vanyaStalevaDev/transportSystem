package org.javaSchool.model.sailIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.VehicleType;

public class PassengerShip extends Ship {
    private static final int DEFAULT_CAPACITY = 1200;
    @CsvBindByName
    private final int capacity;

    @CsvBindByName
    private int passengersNumber;

    public PassengerShip() {
        this(DEFAULT_CAPACITY);
    }

    public PassengerShip(int capacity) {
        this.capacity = capacity;
    }

    public PassengerShip(int capacity, int passengerNum, String plateNumber, ShipEngineType engineType, VehicleType vehicleType) {
        this.capacity = capacity;
        this.passengersNumber = passengerNum;
        this.plateNumber = plateNumber;
        this.engineType = engineType;
        this.vehicleType = vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    @Override
    public void travel() {
        super.travel();
    }

    public void embarkPassengers(int embarkPassengersNum) {
        if (passengersNumber + embarkPassengersNum <= capacity) {
            System.out.printf("%d number of passengers boarded the ship.%n", embarkPassengersNum);
            passengersNumber+=embarkPassengersNum;
        }
    }

    public void debarkPassengers(int debarkPassengersNum) {
        if (passengersNumber - debarkPassengersNum >= 0) {
            System.out.printf("%d passengers are leaving the ship.%n", debarkPassengersNum);
        } else {
            System.out.println("The passengers you want to debark are more than the actual embarked passengers!");
        }
    }

    public void debarkPassengers() {
        this.passengersNumber = 0;
    }

    @Override
    public void endTravel() {
        System.out.printf("The ship arrived at its destination - %s.%n", travelRoute.getEndPoint());
        System.out.printf("All %d passengers will debark the ship.%n", passengersNumber);
        debarkPassengers();
    }

}
