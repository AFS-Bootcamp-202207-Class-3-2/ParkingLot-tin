package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {


    @Test
    void should_return_a_parking_when_park_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);

        //when
        Ticket ticket = parkingLot.park(new Car());

        //then
        assertNotNull(ticket);
    }

    
}
