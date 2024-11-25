package com.quest.exception_handiling.exception_employee;

public class InvalidInputException extends Exception {
private String  message;
    public InvalidInputException(String message) {
        super(message);
    }
}
