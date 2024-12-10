package com.quest.casestudies.serviceCenterBMW;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //part1

        ElectricVehicle ev1 = new ElectricVehicle("BMW", "13", 2020, 3000, "John Doe", 42.5, 150);
        ElectricVehicle ev2 = new ElectricVehicle("BMW", "i8", 2018, 60000, "Jane Smith", 45.0, 200.0);

        CombustionEngineVehicle cv1 = new CombustionEngineVehicle("BMW", "X5", 2015, 70000, "Alice Brown", "Petrol", 3.0);
        CombustionEngineVehicle cv2 = new CombustionEngineVehicle("BMW", "3 Series", 2010, 80000, "Bob White", "Diesel", 2.5);

        ServiceCentre<ElectricVehicle> electricServiceCentre = new ServiceCentre<>();
        ServiceCentre<CombustionEngineVehicle> comServiceCentre = new ServiceCentre<>();

        electricServiceCentre.addServicedVehicle(ev1);
        electricServiceCentre.addServicedVehicle(ev2);

        comServiceCentre.addServicedVehicle(cv1);
        comServiceCentre.addServicedVehicle(cv2);

        //part1 3
        Predicate<Vehicle> highMileagePredicate = v -> v.getMileage() > 50000;
        System.out.println("vehicle with mileage >50000");
        electricServiceCentre.getAllServicedVehicle()
                .stream()
                .filter(highMileagePredicate)
                .forEach(System.out::println);

        comServiceCentre.getAllServicedVehicle()
                .stream()
                .filter(highMileagePredicate)
                .forEach(System.out::println);


        Predicate<Vehicle> oldVehiclePredicate = v -> v.getYear() < 2015;
        System.out.println("vehicle manufatured before 2015");
        electricServiceCentre.getAllServicedVehicle()
                .stream()
                .filter(oldVehiclePredicate)
                .forEach(System.out::println);

        comServiceCentre.getAllServicedVehicle()
                .stream()
                .filter(oldVehiclePredicate)
                .forEach(System.out::println);


        Consumer<Vehicle> vehiclePrinter = v -> System.out.println("VIN " + v.getVin() + " , Mileage " + v.getMileage());
        System.out.println("Vehicle details(VIN and mileage)");
        electricServiceCentre.getAllServicedVehicle().forEach(vehiclePrinter);
        comServiceCentre.getAllServicedVehicle().forEach(vehiclePrinter);

        Supplier<ElectricVehicle> electricVehicleSupplier = () -> new ElectricVehicle("BMW", "iX", 2022, 10000, "Random Owner", 50.0, 300.0);
        System.out.println("generated electric vehicle");
        System.out.println(electricVehicleSupplier.get());

        Supplier<CombustionEngineVehicle> combustionEngineVehicleSupplier = () -> new CombustionEngineVehicle("BMW", "i9", 2023, 10200, "Random Owner", "petrol", 300.0);
        System.out.println("generated electric vehicle");
        System.out.println(electricVehicleSupplier.get());

        Function<Vehicle, Double> calculateResaleValue = v -> {
            double orginalPrice = 50000;
            double depreciationRate = 0.1;
            int yearUsed = Calendar.getInstance().get(Calendar.YEAR) - v.getYear();
            return orginalPrice - (depreciationRate * yearUsed);
        };

        System.out.println("\nResale Values:");
        System.out.println(ev1.getVin() + " resale value: " + calculateResaleValue.apply(ev1));
        System.out.println(cv1.getVin() + " resale value: " + calculateResaleValue.apply(cv1));

        //part 1 4

        System.out.println("\nOldest Vehicle:");
        Vehicle oldestVehicle = comServiceCentre.getAllServicedVehicle()
                .stream()
                .min(Comparator.comparingInt(Vehicle::getYear))
                .orElse(null);
        System.out.println(oldestVehicle);


        System.out.println("vehicle count by type");
        Map<String, Long> vehicleTypeCount = new HashSet<>(List.of(ev1, ev2, cv1, cv2))
                .stream()
                .collect(Collectors.groupingBy(v -> v instanceof ElectricVehicle ? "Electric " : "combustion", Collectors.counting()));
        vehicleTypeCount.forEach((type, count) -> System.out.println(type + " : " + count));
    }
}


    //part2

//    Customer customer1 = new Customer("John", "john@example.com", Vehicle1);
//    Customer customer2 = new Customer("Alice", "alice@example.com", vehicle2);
//}
