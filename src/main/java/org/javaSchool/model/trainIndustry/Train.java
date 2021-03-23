package org.javaSchool.model.trainIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.Route;
import org.javaSchool.model.Vehicle;
import org.javaSchool.model.parking.ParkingReceipt;

import java.util.Objects;

public abstract class Train implements Vehicle {
    protected Route travelRoute;
    @CsvBindByName
    protected String plateNumber;
    @CsvBindByName
    protected TrainEngineType engineType;

    protected ParkingReceipt parkingReceipt;

    @Override
    public void travel() {
        System.out.printf("Travelling on the railroad from %s to %s.%n", travelRoute.getStartPoint(), travelRoute.getEndPoint());
    }

    public void setRoute(Route route) {
        this.travelRoute = route;
    }

    @Override
    public void setParkingReceipt(ParkingReceipt receipt) {
        this.parkingReceipt = receipt;
    }

    @Override
    public ParkingReceipt getParkingReceipt() {
        return parkingReceipt;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public TrainEngineType getEngineType() {
        return engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return plateNumber.equals(train.plateNumber) && engineType == train.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, engineType);
    }
}
