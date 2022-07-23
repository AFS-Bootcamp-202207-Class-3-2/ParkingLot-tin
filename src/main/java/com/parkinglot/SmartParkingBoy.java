package com.parkinglot;


import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy implements ParkingBoy {

    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot currentParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0)
                .max(Comparator.comparingInt(ParkingLot::getCapacity))
                .orElseThrow(NoAvailablePositionException::new);
        return currentParkingLot.park(car);
    }

}
