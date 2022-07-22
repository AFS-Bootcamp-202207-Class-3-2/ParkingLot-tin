package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {


    private int capacity;
    private Map<Ticket, Car> association = new HashMap<>();

    public ParkingLot() {
        capacity = 10;
    }

    public ParkingLot(int capacity) {
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
        if(!association.containsKey(ticket)){
            throw new UnrecognizedParingTicketException();
        }
        return association.get(ticket);
    }
}
