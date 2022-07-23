package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {

    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot currentParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0)
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new);
            return currentParkingLot.park(car);

    }

    public Car fetch(Ticket ticket) {
        ParkingLot currentParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasCar(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedParingTicketException::new);
        return currentParkingLot.fetch(ticket);
    }
}
