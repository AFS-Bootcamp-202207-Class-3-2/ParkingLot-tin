package com.parkinglot;


import java.util.List;

public class ManageParkingLot {

    private ParkingBoy parkingBoy;

    private List<ParkingLot> parkingLots;

    public ManageParkingLot(ParkingBoy parkingBoy, List<ParkingLot> parkingLots) {
        this.parkingBoy = parkingBoy;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingBoy.park(car, parkingLots);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot currentParkingLot =parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasCar(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedParingTicketException::new);
        return currentParkingLot.fetch(ticket);
    }
}
