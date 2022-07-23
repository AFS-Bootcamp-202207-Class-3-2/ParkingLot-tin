package com.parkinglot;


import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot currentParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0)
                .sorted(Comparator.comparingDouble(ParkingLot::calculateVacancyRate).reversed())
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new);
        return currentParkingLot.park(car);

    }

    public Car fetch(Ticket ticket) {
        ParkingLot currentParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasContainsKey(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedParingTicketException::new);
        return currentParkingLot.fetch(ticket);
    }
}
