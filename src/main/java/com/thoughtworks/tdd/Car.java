package com.thoughtworks.tdd;

public class Car {

    private  boolean isParked;

    public Car() {
    }

    public Car(boolean isParked) {
        this.isParked = isParked;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }
}
