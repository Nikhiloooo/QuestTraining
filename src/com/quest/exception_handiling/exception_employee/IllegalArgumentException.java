package com.quest.exception_handiling.exception_employee;

public class IllegalArgumentException extends RuntimeException {
    private String message;
    public IllegalArgumentException(String message) {
        super(message);
    }
}
