package org.javaSchool.model.sailIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.Loadable;

public class CargoShip extends Ship implements Loadable {
    private static final int DEFAULT_LOAD_CAPACITY = 100;
    @CsvBindByName
    private int loadWeight;
    @CsvBindByName
    private final int loadCapacity;

    public CargoShip() {
        this(DEFAULT_LOAD_CAPACITY);
    }

    public CargoShip(int capacity) {
        this.loadCapacity = capacity;
    }

    public CargoShip(int capacity, String plateNumber, ShipEngineType engineType, int loadWeight) {
        this.loadCapacity = capacity;
        this.plateNumber = plateNumber;
        this.engineType = engineType;
        this.loadWeight = loadWeight;
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
            System.out.printf("The ship loaded a %d tons of cargo%n", weight);
            loadWeight += weight;
        } else {
            System.out.printf("The total weight exceeds the load capacity of the ship. The load of %d weight will not be loaded.%n", weight);
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
        System.out.printf("The ship arrived at its destination - %s.%n", travelRoute.getEndPoint());
        System.out.printf("The ship will unload its load of %d kg.%n", loadWeight);
        unload();
    }
}
