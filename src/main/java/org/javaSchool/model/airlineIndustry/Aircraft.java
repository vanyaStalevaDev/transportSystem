package org.javaSchool.model.airlineIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.Route;
import org.javaSchool.model.Vehicle;
import org.javaSchool.model.parking.ParkingReceipt;

import java.util.Objects;

public abstract class Aircraft implements Vehicle {
    protected Route travelRoute;
    @CsvBindByName
    protected String plateNumber;

    @CsvBindByName
    protected AircraftEngineType engineType;

    protected ParkingReceipt parkingReceipt;

    @Override
    public void setParkingReceipt(ParkingReceipt parkingReceipt) {
        this.parkingReceipt = parkingReceipt;
    }

    @Override
    public ParkingReceipt getParkingReceipt() {
        return parkingReceipt;
    }

    @Override
    public void travel() {
        System.out.printf("Flying from %s to %s.%n", travelRoute.getStartPoint(), travelRoute.getEndPoint());
    }

    public void setRoute(Route route) {
        this.travelRoute = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return plateNumber.equals(aircraft.plateNumber) && engineType == aircraft.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, engineType);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public AircraftEngineType getEngineType() {
        return engineType;
    }
}
