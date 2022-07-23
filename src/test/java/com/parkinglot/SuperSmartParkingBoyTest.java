package com.parkinglot;


import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    //Story 6
    @Test
    void should_park_first_lot_when_park_given_with_two_parking_lots_of_the_same_rate() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(3));
        parkingLotList.add(new ParkingLot(3));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        //when
        Ticket ticket = superSmartParkingBoy.park(new Car());
        //then
        assertTrue(parkingLotList.get(0).hasContainsKey(ticket));
    }

    @Test
    void should_park_second_lot_when_park_given_with_second_parking_lot_more_rate() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(3));
        parkingLotList.add(new ParkingLot(3));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        superSmartParkingBoy.park(new Car());

        //when
        assertEquals(parkingLotList.get(1).calculateVacancyRate(),parkingLotList.stream()
                .map(ParkingLot::calculateVacancyRate)
                .max(Double::compareTo)
                .get());
        Ticket ticket = superSmartParkingBoy.park(new Car());
        //then
        assertTrue(parkingLotList.get(1).hasContainsKey(ticket));
    }

    @Test
    void should_return_the_right_car_when_fetch_given_with_two_parking_tickets_and_two_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(2));
        parkingLotList.add(new ParkingLot(2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        Car actualCarA = new Car();
        Car actualCarB = new Car();
        Ticket ticketA = superSmartParkingBoy.park(actualCarA);
        Ticket ticketB = superSmartParkingBoy.park(actualCarB);

        //when
        Car carA = superSmartParkingBoy.fetch(ticketA);
        Car carB = superSmartParkingBoy.fetch(ticketB);

        //then
        assertEquals(actualCarA,carA);
        assertEquals(actualCarB,carB);
    }
}
