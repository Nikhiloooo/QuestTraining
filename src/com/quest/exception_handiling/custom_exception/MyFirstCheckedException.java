package com.quest.exception_handiling.custom_exception;

public class MyFirstCheckedException extends Exception {

    private String exceptionmessage;
    public MyFirstCheckedException(String exceptionmessage) {
        super(exceptionmessage);
        this.exceptionmessage = exceptionmessage;
    }

    public String reason()
    {
        return "custom static message: "+exceptionmessage;
    }

}
