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
        Car actualCar = new Car();
        Ticket ticket = parkingLot.park(actualCar);
        //when
        Car car = parkingLot.fetch(ticket);

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

    @Test
    void should_throw_Unrecognized_parking_ticket_when_fetch_given_an_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        UnrecognizedParingTicketException exception = assertThrows(
                UnrecognizedParingTicketException.class,
                () -> parkingLot.fetch(new Ticket()));
        //then
        assertEquals("Unrecognized paring ticket", exception.getMessage());
    }

    @Test
    void should_throw_Unrecognized_parking_ticket_when_fetch_given_a_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //when
        UnrecognizedParingTicketException exception = assertThrows(
                UnrecognizedParingTicketException.class,
                () -> parkingLot.fetch(new Ticket()));
        //then
        assertEquals("Unrecognized paring ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_when_park_given_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        //when
        NoAvailablePositionException exception = assertThrows(
                NoAvailablePositionException.class,
                () -> parkingLot.park(new Car()));

        //then
        assertEquals("No available position", exception.getMessage());
    }

}
