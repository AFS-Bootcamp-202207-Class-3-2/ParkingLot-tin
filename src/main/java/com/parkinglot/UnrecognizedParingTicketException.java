package com.parkinglot;

public class UnrecognizedParingTicketException extends RuntimeException{

    public UnrecognizedParingTicketException() {
        super("Unrecognized paring ticket");
    }
}
