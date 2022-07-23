package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int fullCapacity;

    private int capacity;

    private Map<Ticket, Car> association = new HashMap<>();

    public ParkingLot() {
        fullCapacity = 10;
        capacity = fullCapacity;
    }

    public ParkingLot(int capacity) {
        fullCapacity = capacity;
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if(capacity == 0){
            throw new NoAvailablePositionException();
        }
        capacity --;
        Ticket ticket = new Ticket();
        association.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(!hasCar(ticket)){
            throw new UnrecognizedParingTicketException();
        }
        capacity ++;
        Car car = association.get(ticket);
        association.remove(ticket);
        return car;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasCar(Ticket ticket) {
        return association.containsKey(ticket);
    }

    public double calculateVacancyRate() {
        return 1.0 * getCapacity() / fullCapacity;
    }

}
