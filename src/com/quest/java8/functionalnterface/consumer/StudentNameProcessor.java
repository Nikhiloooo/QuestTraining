package com.quest.java8.functionalnterface.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StudentNameProcessor {
    public static void main(String[] args) {

        List<String> studentNames =  new ArrayList<>(Arrays.asList("John", "Jane", "Paul"));


        Consumer<String> printUpperCase = name ->
                System.out.println(name.toUpperCase());


        Consumer<String> printLength = name ->
                System.out.println("Length: " + name.length());


        studentNames.forEach(name -> {
            printUpperCase.accept(name);
            printLength.accept(name);
        });
    }
}
