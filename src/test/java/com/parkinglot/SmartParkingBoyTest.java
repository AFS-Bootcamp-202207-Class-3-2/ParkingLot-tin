package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 陈祁天
 * @date 2022/7/23
 * @description
 */
public class SmartParkingBoyTest {
    //Story 5
    @Test
    void should_park_first_lot_when_park_given_with_two_empty_parking_lots_of_the_same_number_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(2));
        parkingLotList.add(new ParkingLot(2));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);

        //when
        Ticket ticket = smartParkingBoy.park(new Car());

        //then
        assertTrue(parkingLotList.get(0).hasContainsKey(ticket));
    }

    @Test
    void should_return_the_right_car_when_fetch_given_with_two_parking_tickets_and_two_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        Car actualCarA = new Car();
        Car actualCarB = new Car();
        Ticket ticketA = smartParkingBoy.park(actualCarA);
        Ticket ticketB = smartParkingBoy.park(actualCarB);

        //when
        Car carA = smartParkingBoy.fetch(ticketA);
        Car carB = smartParkingBoy.fetch(ticketB);

        //then
        assertEquals(actualCarA,carA);
        assertEquals(actualCarB,carB);
    }
}