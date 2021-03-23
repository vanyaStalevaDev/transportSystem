package org.javaSchool.model.trainIndustry;

import com.opencsv.bean.CsvBindByName;

public class PassengerTrain extends Train {
    @CsvBindByName
    int capacity;
    private static final int DEFAULT_CAPACITY = 500;
    @CsvBindByName
    int passengerNumber;

    public PassengerTrain() {

        this(DEFAULT_CAPACITY);
        passengerNumber = 0;
    }

    public PassengerTrain(int capacity) {
        this.capacity = capacity;
        passengerNumber = 0;
    }

    public PassengerTrain(int capacity, int passengerNum) {
        this.capacity = capacity;
        passengerNumber = passengerNum;
    }

    public PassengerTrain(String plateNumber, int capacity, int passengerNumber, TrainEngineType engineType){
        this.capacity = capacity;
        this.plateNumber = plateNumber;
        this.passengerNumber = passengerNumber;
        this.engineType = engineType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPassengersNumber() {
        return passengerNumber;
    }

    public void embarkPassengers(int embarkPassengersNum) {
        if (passengerNumber + embarkPassengersNum <= capacity) {
            System.out.printf("%d number of passengers embarked the train.%n", embarkPassengersNum);
            passengerNumber += embarkPassengersNum;
        } else {
            System.out.printf("The number of passengers exceeds the capacity. The %d number of passengers will not be embarked.%n", embarkPassengersNum);
        }
    }

    public void debarkPassengers(int debarkPassengersNum) {
        if (passengerNumber - debarkPassengersNum >= 0) {
            System.out.printf("%d passengers are leaving the train", debarkPassengersNum);
        } else {
            System.out.println("The passengers you want to debark are more than the actual embarked passengers!");
        }
    }

    public void debarkPassengers() {
        this.passengerNumber = 0;
    }

    @Override
    public void endTravel() {
        System.out.printf("The train arrived at its destination - %s.%n", travelRoute.getEndPoint());
        System.out.printf("All %d passengers will debark the train.%n", passengerNumber);
        debarkPassengers();
    }

}
