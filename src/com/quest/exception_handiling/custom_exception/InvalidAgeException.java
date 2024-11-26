package com.quest.exception_handiling.custom_exception;

public class InvalidAgeException extends RuntimeException {
    private  int age;
    private String message;
    public InvalidAgeException(int age, String message) {
        super(message);
        this.age = age;
        this.message = message;
    }
    public String reason(){
        return "foer voting ,minimum age is: "+age+" exception: "+message;
    }

    @Override
    public String toString() {
        return "invalid age exception: "+reason();
    }
}
