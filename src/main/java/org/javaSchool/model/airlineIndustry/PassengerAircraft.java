package org.javaSchool.model.airlineIndustry;

import com.opencsv.bean.CsvBindByName;

public class PassengerAircraft extends Aircraft {
    private static final int DEFAULT_CAPACITY = 200;
    @CsvBindByName
    private final int capacity;
    @CsvBindByName
    private int passengersNumber;

    public PassengerAircraft() {
        this(DEFAULT_CAPACITY);
    }

    public PassengerAircraft(int capacity) {
        this.capacity = capacity;
    }

    public PassengerAircraft(int capacity, String plateNumber, AircraftEngineType engineType, int passengersNumber) {
        this.capacity = capacity;
        this.passengersNumber = passengersNumber;
        this.engineType = engineType;
        this.plateNumber = plateNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void embarkPassengers(int embarkPassengersNum) {
        if (passengersNumber + embarkPassengersNum <= capacity) {
            System.out.printf("%d number of passengers boarded the aircraft.%n", embarkPassengersNum);
        } else {
            System.out.printf("The number of passengers exceed the capacity. The %d number of passengers will not be embarked.%n", embarkPassengersNum);
        }
    }

    public void debarkPassengers(int debarkPassengersNum) {
        if (passengersNumber - debarkPassengersNum >= 0) {
            System.out.printf("%d passengers are leaving the plane", debarkPassengersNum);
        } else {
            System.out.println("The passengers you want to debark are more than the actual embarked passengers!");
        }
    }

    public void debarkPassengers() {
        this.passengersNumber = 0;
    }


    @Override
    public void endTravel() {
        System.out.printf("The plane arrived at its destination - %s.%n", travelRoute.getEndPoint());
        System.out.printf("All %d passengers will debark the plane.%n", passengersNumber);
        debarkPassengers();
    }
}
