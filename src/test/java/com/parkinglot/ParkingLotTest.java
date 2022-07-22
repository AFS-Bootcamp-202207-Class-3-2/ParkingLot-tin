package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {


    @Test
    void should_return_a_ticket_when_park_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);

        //when
        Ticket ticket = parkingLot.park(new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_park_given_a_full_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Ticket ticketFist = parkingLot.park(new Car());
        Ticket ticketSecond = parkingLot.park(new Car());

        //then
        assertNotNull(ticketFist);
        assertNull(ticketSecond);
    }
}
