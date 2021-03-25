package org.javaSchool.model.sailIndustry;

import com.opencsv.bean.CsvBindByName;
import org.javaSchool.model.Route;
import org.javaSchool.model.Vehicle;
import org.javaSchool.model.VehicleType;
import org.javaSchool.model.parking.ParkingReceipt;

import java.util.Objects;

public abstract class Ship implements Vehicle {
    protected Route travelRoute;
    @CsvBindByName
    protected String plateNumber;
    @CsvBindByName
    protected ShipEngineType engineType;
    protected ParkingReceipt parkingReceipt;
    @CsvBindByName
    protected VehicleType vehicleType;

    public void travel() {
        System.out.printf("Sailing from %s to %s.%n", travelRoute.getStartPoint(), travelRoute.getEndPoint());
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
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

    public ShipEngineType getEngineType() {
        return engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return plateNumber.equals(ship.plateNumber) && engineType == ship.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, engineType);
    }
}
