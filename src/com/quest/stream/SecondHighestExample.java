package com.quest.stream;

import java.util.*;
import java.util.stream.*;

public class SecondHighestExample {
    public static void main(String[] args) {


        Stream<Integer>intStream = Stream.of(1,6,7,3,2,8,9,10);
        Optional<Integer> secondHighest = intStream
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();

        if (secondHighest.isPresent()) {
            System.out.println(secondHighest.get());
        } else {
            System.out.println("Second highest element not found");
        }
    }
}



