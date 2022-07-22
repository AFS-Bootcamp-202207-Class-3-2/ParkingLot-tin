package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        ParkingLot fullParkingLot = new ParkingLot(1);

        //when
        Ticket ticketFist = fullParkingLot.park(new Car());
        Ticket ticketSecond = fullParkingLot.park(new Car());

        //then
        assertNotNull(ticketFist);
        assertNull(ticketSecond);
    }

    @Test
    void should_return_a_car_when_fetch_given_a_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Car car = parkingLot.fetch(new Ticket());

        //then
        assertNotNull(car);
    }

    @Test
    void should_return_the_right_car_when_fetch_given_two_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car actualCarA = new Car();
        Car actualCarB = new Car();
        Ticket ticketA = parkingLot.park(actualCarA);
        Ticket ticketB = parkingLot.park(actualCarB);

        //when
        Car carA = parkingLot.fetch(ticketA);
        Car carB = parkingLot.fetch(ticketB);


        //then
        assertEquals(actualCarA,carA);
        assertEquals(actualCarB,carB);

    }
}
