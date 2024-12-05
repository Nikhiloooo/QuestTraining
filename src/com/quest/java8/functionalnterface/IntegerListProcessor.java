package com.quest.java8.functionalnterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IntegerListProcessor {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        Predicate<Integer> isEven = number -> number % 2 == 0;


        Consumer<List<Integer>> multiplyByTwo = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
        };


        Supplier<List<Integer>> getTransformedList = () -> {

            List<Integer> filteredList = new ArrayList<>();
            for (Integer number : numbers) {
                if (isEven.test(number)) {
                    filteredList.add(number);
                }
            }


            multiplyByTwo.accept(filteredList);

            return filteredList;
        };


        List<Integer> transformedList = getTransformedList.get();


        System.out.println("Transformed List: " + transformedList);
    }
}

