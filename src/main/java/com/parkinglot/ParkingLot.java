package com.parkinglot;

public class ParkingLot {

    private int capacity;

    public ParkingLot() {
        capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        return new Ticket();
    }
}
