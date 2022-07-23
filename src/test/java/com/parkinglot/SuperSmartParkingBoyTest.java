package com.parkinglot;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {

    SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

    //Story 6
    @Test
    void should_park_first_lot_when_park_given_with_two_parking_lots_of_the_same_rate() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(3));
            add(new ParkingLot(3));
        }};

        ManageParkingLot manageParkingLot = new ManageParkingLot(superSmartParkingBoy, parkingLotList);

        manageParkingLot.park(new Car());
        manageParkingLot.park(new Car());

        //when
        Ticket ticket = manageParkingLot.park(new Car());
        //then
        assertTrue(parkingLotList.get(0).hasCar(ticket));
    }

    @Test
    void should_park_second_lot_when_park_given_with_second_parking_lot_more_rate() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(3));
            add(new ParkingLot(3));
        }};
        ManageParkingLot manageParkingLot = new ManageParkingLot(superSmartParkingBoy, parkingLotList);

        manageParkingLot.park(new Car());

        //when
        Ticket ticket = manageParkingLot.park(new Car());
        //then
        assertTrue(parkingLotList.get(1).hasCar(ticket));
    }

    @Test
    void should_return_the_right_car_when_fetch_given_with_two_parking_tickets_and_two_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(3));
            add(new ParkingLot(3));
        }};
        ManageParkingLot manageParkingLot = new ManageParkingLot(superSmartParkingBoy, parkingLotList);


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
    void should_throw_Unrecognized_parking_ticket_when_fetch_given_with_an_unrecognized_ticket_and_two_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(3));
            add(new ParkingLot(3));
        }};
        ManageParkingLot manageParkingLot = new ManageParkingLot(superSmartParkingBoy, parkingLotList);

        //when
        UnrecognizedParingTicketException exception = assertThrows(
                UnrecognizedParingTicketException.class,
                () -> manageParkingLot.fetch(new Ticket()));
        //then
        assertEquals("Unrecognized paring ticket", exception.getMessage());
    }

    @Test
    void should_throw_Unrecognized_parking_ticket_when_fetch_given_with_a_used_ticket_and_two_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
            add(new ParkingLot(1));
        }};
        ManageParkingLot manageParkingLot = new ManageParkingLot(superSmartParkingBoy, parkingLotList);
        Ticket ticket = manageParkingLot.park(new Car());
        manageParkingLot.fetch(ticket);
        //when
        UnrecognizedParingTicketException exception = assertThrows(
                UnrecognizedParingTicketException.class,
                () -> manageParkingLot.fetch(ticket));
        //then
        assertEquals("Unrecognized paring ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_when_park_given_with_a_car_and_two_full_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>(){{
            add(new ParkingLot(1));
            add(new ParkingLot(1));
        }};
        ManageParkingLot manageParkingLot = new ManageParkingLot(superSmartParkingBoy, parkingLotList);
        manageParkingLot.park(new Car());
        manageParkingLot.park(new Car());

        //when
        NoAvailablePositionException exception = assertThrows(
                NoAvailablePositionException.class,
                () -> manageParkingLot.park(new Car()));

        //then
        assertEquals("No available position", exception.getMessage());
    }
}
