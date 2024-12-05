package com.quest.java8.functionalnterface.supplier;

import java.util.function.Supplier;

public class RandomNumberGenerator {
    public static void main(String[] args) {

        Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100) + 1;

        System.out.println("Random Number 1: " + randomNumberSupplier.get());
        System.out.println("Random Number 2: " + randomNumberSupplier.get());
        System.out.println("Random Number 3: " + randomNumberSupplier.get());
    }
}
