package com.parkinglot;


import java.util.List;

public interface ParkingBoy {

    Ticket park(Car car, List<ParkingLot> parkingLots);

}
