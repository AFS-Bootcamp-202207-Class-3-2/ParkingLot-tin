package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {

    StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
    //Story 3
    @Test
    void should_return_a_ticket_when_park_given_a_parking_boy_with_a_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(standardParkingBoy, parkingLotList);

        //when
        Ticket ticket = manageParkingLot.park(new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_fetch_given_a_parking_boy_with_a_parking_ticket() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(standardParkingBoy, parkingLotList);
        Car actualCar = new Car();
        Ticket ticket = manageParkingLot.park(actualCar);
        //when
        Car car = manageParkingLot.fetch(ticket);

        //then
        assertNotNull(car);
    }

    @Test
    void should_return_the_right_car_when_fetch_given_a_parking_boy_with_two_parking_ticket() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(2));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(standardParkingBoy, parkingLotList);
        Car actualCarA = new Car();
        Car actualCarB = new Car();
        Ticket ticketA = manageParkingLot.park(actualCarA);
        Ticket ticketB = manageParkingLot.park(actualCarB);

        //when
        Car carA = manageParkingLot.fetch(ticketA);
        Car carB = manageParkingLot.fetch(ticketB);

        //then
        assertEquals(actualCarA,carA);
        assertEquals(actualCarB,carB);
    }

    @Test
    void should_throw_Unrecognized_parking_ticket_when_fetch_given_a_parking_boy_with_an_unrecognized_ticket() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(standardParkingBoy, parkingLotList);

        //when
        UnrecognizedParingTicketException exception = assertThrows(
                UnrecognizedParingTicketException.class,
                () -> manageParkingLot.fetch(new Ticket()));
        //then
        assertEquals("Unrecognized paring ticket", exception.getMessage());
    }

    @Test
    void should_throw_Unrecognized_parking_ticket_when_fetch_given_a_parking_boy_with_a_used_ticket() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(standardParkingBoy, parkingLotList);
        Car car = new Car();
        Ticket ticket = manageParkingLot.park(car);
        manageParkingLot.fetch(ticket);
        //when
        UnrecognizedParingTicketException exception = assertThrows(
                UnrecognizedParingTicketException.class,
                () -> manageParkingLot.fetch(ticket));
        //then
        assertEquals("Unrecognized paring ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_when_park_given_a_parking_boy_with_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(standardParkingBoy, parkingLotList);
        manageParkingLot.park(new Car());

        //when
        NoAvailablePositionException exception = assertThrows(
                NoAvailablePositionException.class,
                () -> manageParkingLot.park(new Car()));

        //then
        assertEquals("No available position", exception.getMessage());
    }
}
