package com.parkinglot;


import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {
    //Story 6
    @Test
    void should_park_first_lot_when_park_given_with_two_parking_lots_of_the_same_rate() {
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

    @Test
    void should_park_second_lot_when_park_given_with_second_parking_lot_more_rate() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(3));
        parkingLotList.add(new ParkingLot(3));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        smartParkingBoy.park(new Car());

        //when
        assertEquals(parkingLotList.get(1).calculateVacancyRate(),parkingLotList.stream()
                .map(ParkingLot::calculateVacancyRate)
                .max(Double::compareTo)
                .get());
        Ticket ticket = smartParkingBoy.park(new Car());
        //then
        assertTrue(parkingLotList.get(1).hasContainsKey(ticket));
    }
}
