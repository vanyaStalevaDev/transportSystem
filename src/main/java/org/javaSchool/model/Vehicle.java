package org.javaSchool.model;

import org.javaSchool.model.parking.ParkingReceipt;

public interface Vehicle {

    public void travel();

    public void endTravel();

    public String getPlateNumber();

    public void setParkingReceipt(ParkingReceipt receipt);

    public ParkingReceipt getParkingReceipt();

    public VehicleType getVehicleType();
}
