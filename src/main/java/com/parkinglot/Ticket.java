package com.parkinglot;

public class Ticket {

    private Car car;

    public Ticket() {

    }

    public Ticket(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
