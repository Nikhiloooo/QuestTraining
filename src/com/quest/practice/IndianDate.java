package com.quest.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IndianDate {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("normal format : " + ldt);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = dtf.format(ldt);
        System.out.println("Indian format : "+date);

    }
}
