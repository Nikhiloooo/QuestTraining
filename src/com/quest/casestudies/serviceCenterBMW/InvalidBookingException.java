package com.quest.casestudies.serviceCenterBMW;

public class InvalidBookingException extends RuntimeException {
    public InvalidBookingException(String message) {
        super(message);
    }
}
