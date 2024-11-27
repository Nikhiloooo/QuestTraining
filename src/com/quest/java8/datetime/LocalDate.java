package com.quest.java8.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDate {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("localdatetime "+currentDateTime);

        //Data formatter  format the data into a readable string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        //Applying the formatter
        String formattedDateTime = currentDateTime.format(formatter);

        //output the formatted data
        System.out.println("formattedDateTime "+formattedDateTime);


        LocalDateTime someOtherDate=LocalDateTime.of(2023,12,12,13,12,45);
        System.out.println("someOtherDate "+someOtherDate);

        boolean after=currentDateTime.isAfter(someOtherDate);
        System.out.println("after "+after);

        LocalDateTime plus = currentDateTime.plus(12,ChronoUnit .DAYS);
        System.out.println("plus "+plus);
    }
}
