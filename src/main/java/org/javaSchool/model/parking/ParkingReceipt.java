package org.javaSchool.model.parking;

import java.time.LocalDateTime;

public class ParkingReceipt {
    LocalDateTime arrivalTime;
    LocalDateTime exitTime;
    double cost;
    String registrationPlate;
//    int parkingSpace;

    @Override
    public String toString() {
        return "ParkingReceipt{" +
                "arrivalTime=" + arrivalTime.getHour() + ":" + arrivalTime.getMinute() +
                ", exitTime=" + exitTime.getHour() + ":" + exitTime.getMinute() +
                ", cost=" + cost +
                ", registrationPlate='" + registrationPlate + '\'' +
                '}';
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
