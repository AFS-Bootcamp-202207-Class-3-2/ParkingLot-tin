package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBobTest {
    //Story 4
    @Test
    void should_return_a_ticket_when_park_given_with_two_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);

        //when
        Ticket ticket = standardParkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_ticket_when_park_given_with_one_full_lot_and_a_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        standardParkingBoy.park(new Car());
        Car actualCar = new Car();

        //when
        Ticket ticket = standardParkingBoy.park(actualCar);

        //then
        assertNotNull(ticket);
    }


    @Test
    void should_return_the_right_car_when_fetch_given_a_parking_boy_with_two_parking_ticket_and_two_lot() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car actualCarA = new Car();
        Car actualCarB = new Car();
        Ticket ticketA = standardParkingBoy.park(actualCarA);
        Ticket ticketB = standardParkingBoy.park(actualCarB);

        //when
        Car carA = standardParkingBoy.fetch(ticketA);
        Car carB = standardParkingBoy.fetch(ticketB);

        //then
        assertEquals(actualCarA,carA);
        assertEquals(actualCarB,carB);
    }
//
//    @Test
//    void should_throw_Unrecognized_parking_ticket_when_fetch_given_a_parking_boy_with_an_unrecognized_ticket() {
//        //given
//        List<ParkingLot> parkingLotList = new ArrayList<>();
//        parkingLotList.add(new ParkingLot(1));
//        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
//
//        //when
//        UnrecognizedParingTicketException exception = assertThrows(
//                UnrecognizedParingTicketException.class,
//                () -> standardParkingBoy.fetch(new Ticket()));
//        //then
//        assertEquals("Unrecognized paring ticket", exception.getMessage());
//    }
//
//    @Test
//    void should_throw_Unrecognized_parking_ticket_when_fetch_given_a_parking_boy_with_a_used_ticket() {
//        //given
//        List<ParkingLot> parkingLotList = new ArrayList<>();
//        parkingLotList.add(new ParkingLot(1));
//        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
//        Car car = new Car();
//        Ticket ticket = standardParkingBoy.park(car);
//        standardParkingBoy.fetch(ticket);
//        //when
//        UnrecognizedParingTicketException exception = assertThrows(
//                UnrecognizedParingTicketException.class,
//                () -> standardParkingBoy.fetch(new Ticket()));
//        //then
//        assertEquals("Unrecognized paring ticket", exception.getMessage());
//    }
//
//    @Test
//    void should_throw_no_available_position_when_park_given_a_parking_boy_with_a_car() {
//        //given
//        List<ParkingLot> parkingLotList = new ArrayList<>();
//        parkingLotList.add(new ParkingLot(1));
//        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
//        standardParkingBoy.park(new Car());
//
//        //when
//        NoAvailablePositionException exception = assertThrows(
//                NoAvailablePositionException.class,
//                () -> standardParkingBoy.park(new Car()));
//
//        //then
//        assertEquals("No available position", exception.getMessage());
//    }
}
