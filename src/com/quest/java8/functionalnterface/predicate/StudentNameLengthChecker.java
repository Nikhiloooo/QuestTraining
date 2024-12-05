package com.quest.java8.functionalnterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StudentNameLengthChecker {
    public static void main(String[] args) {
        // List of student names
        List<String> studentNames = Arrays.asList("John", "Jane", "Paul", "Elizabeth");


        Predicate<String> isLengthGreaterThan = name -> name.length() >4;


        for (String name : studentNames) {
            System.out.println("Name: " + name);
            System.out.println("Is length > " + "4 " + "=" + isLengthGreaterThan.test(name));
            System.out.println();
        }
    }
}

