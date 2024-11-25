package com.quest.exception_handiling.exception_employee;

public class Manager extends Employee{

    private final int teamSize;
    public Manager(String name, int age,double salary, int teamSize) throws InvalidInputException,IllegalArgumentException {
        super(name, age, salary);
        if(teamSize < 1 ){
           throw new IllegalArgumentException(" Team size must be greater than 0 ");
        }
        this.teamSize = teamSize;

    }


    @Override
    public String toString() {
        return super.toString() + "\nTeam Size: " + teamSize;
    }

}
