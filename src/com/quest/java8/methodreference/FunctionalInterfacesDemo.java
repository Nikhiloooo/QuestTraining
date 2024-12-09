package com.quest.java8.methodreference;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        Supplier<Integer> randomIntSupplier = () -> (int)(Math.random()*101);

        Predicate<Integer> isEvenPredicate = FunctionalInterfacesDemo::isEven;

        Function<Integer, Integer> processFunction = number->{
            if(isEvenPredicate.test(number)){
                return number*number;

            }
            else{
                return number*2;
            }
        };
        Consumer<String> resultConsumer = System.out::println;


        processInteger(randomIntSupplier, isEvenPredicate, processFunction, resultConsumer);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;


    }

    public static void processInteger(Supplier<Integer> supplier, Predicate<Integer> predicate,
                                      Function<Integer, Integer> function, Consumer<String> consumer) {
        int number = supplier.get();
        Optional<Integer> result = Optional.empty();
        if (predicate.test(number)) {
            Integer processedValue = function.apply(number);
            result = Optional.of(processedValue);
        }

        result.ifPresentOrElse(
                value -> consumer.accept("Result: " + value),
                () -> consumer.accept("No result")
        );
    }

}
