package org.javaSchool.model.trainIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.Loadable;

public class CargoTrain extends Train implements Loadable {
    private static final int DEFAULT_LOAD_CAPACITY = 100;
    @CsvBindByName
    private final int loadCapacity;
    @CsvBindByName
    private int loadWeight;

    public CargoTrain(){
        this(DEFAULT_LOAD_CAPACITY);
    }

    public CargoTrain(int capacity){
        this.loadCapacity = capacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getLoadWeight() {
        return loadWeight;
    }

    @Override
    public void load(int weight) {
        if (weight <= 0) {
            System.out.println("Load weight should be a positive number!");
            return;
        }
        if (this.loadCapacity - (loadWeight + weight) >= 0) {
            System.out.printf("The train loaded a %d tons of cargo%n", weight);
            loadWeight += weight;
        } else {
            System.out.printf("The total weight exceeds the load capacity of the train. The load of %d weight will not be loaded.%n", weight);
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
        System.out.printf("The train arrived at its destination - %s.%n", travelRoute.getEndPoint());
        System.out.printf("The train will unload its load of %d kg.%n", loadWeight);
        unload();
    }
}
