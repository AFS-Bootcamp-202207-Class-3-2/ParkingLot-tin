package com.parkinglot;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {
    //Story 6
    @Test
    void should_park_first_lot_when_park_given_with_two_parking_lots_of_the_same_rate_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(3));
        parkingLotList.add(new ParkingLot(3));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());
        //when
        Ticket ticket = smartParkingBoy.park(new Car());
        //then
        assertTrue(parkingLotList.get(0).hasContainsKey(ticket));
    }
}
