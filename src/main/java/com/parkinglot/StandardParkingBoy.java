package com.parkinglot;

import java.util.List;

public class StandardParkingBoy implements ParkingBoy {

    @Override
    public Ticket park(Car car, List<ParkingLot> parkingLots) {
        ParkingLot currentParkingLot = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getCapacity() != 0)
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new);
            return currentParkingLot.park(car);

    }

}
