package org.javaSchool.model.airlineIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.Loadable;

public class CargoAirCraft extends Aircraft implements Loadable{
    private static final int DEFAULT_LOAD_CAPACITY = 300;
    @CsvBindByName
    private int loadWeight;
    @CsvBindByName
    private final int loadCapacity;

    public CargoAirCraft() {
        this(DEFAULT_LOAD_CAPACITY);
    }

    public CargoAirCraft(int capacity) {
        this.loadCapacity = capacity;
    }

    public CargoAirCraft(int capacity, String plateNumber, AircraftEngineType engineType, int loadWeight) {
        this.loadCapacity = capacity;
        this.loadWeight = loadWeight;
        this.engineType = engineType;
        this.plateNumber = plateNumber;
    }

    public int getLoadWeight() {
        return loadWeight;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public void load(int weight) {
        if (weight <= 0) {
            System.out.println("Load weight should be a positive number!");
            return;
        }
        if (this.loadCapacity - (loadWeight + weight) >= 0) {
            System.out.printf("The plane loaded a %d tons of cargo%n", weight);
            loadWeight += weight;
        } else {
            System.out.printf("The total weight exceeds the load capacity of the plane. The load of %d weight will not be loaded.%n", weight);
        }

    }

    @Override
    public void unload(int weight) {
        if (loadWeight - weight >= 0) {
            loadWeight -= weight;
        } else {
            System.out.println("The weight you try to unload is more than the actual load");
        }
    }

    public void unload() {
        loadWeight = 0;
    }

    @Override
    public void endTravel() {
        System.out.printf("The plane arrived at its destination - %s.%n", travelRoute.getEndPoint());
        System.out.printf("The plane will unload its load of %d kg.%n", loadWeight);
        unload();
    }

}
