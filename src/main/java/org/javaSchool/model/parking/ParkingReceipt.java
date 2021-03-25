package org.javaSchool.model.parking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingReceipt {
    private LocalDateTime arrivalTime = LocalDateTime.now().withHour(0).withMinute(0);
    private LocalDateTime exitTime = LocalDateTime.now().withHour(0).withMinute(0);
    ;
    private double cost;
    private String registrationPlate;
    private int parkingSpace;

    public ParkingReceipt() {
        this(0.0, "", -1);

    }

    public ParkingReceipt(double cost, String registrationPlate, int parkingSpace) {
        this.cost = cost;
        this.registrationPlate = registrationPlate;
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        return "ParkingReceipt{" +
                "arrivalTime=" + arrivalTime.format(DateTimeFormatter.ofPattern("HH::mm")) + //":" + arrivalTime.getMinute() +
                ", exitTime=" + exitTime.getHour() + ":" + exitTime.getMinute() +
                ", cost=" + cost +
                ", registrationPlate='" + registrationPlate + '\'' +
                '}';

//        dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"))
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

}
