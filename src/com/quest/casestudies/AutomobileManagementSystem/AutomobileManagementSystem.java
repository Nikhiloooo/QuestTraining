package com.quest.casestudies.AutomobileManagementSystem;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutomobileManagementSystem {

    private static List<Vehicle> inventory = Arrays.asList(
            new Car("C001", "Toyota", "Camry", 30000, LocalDate.of(2022, 5, 10), 5),
            new Car("C002", "Honda", "Civic", 25000, LocalDate.of(2021, 3, 15), 5),
            new Car("C003", "Ford", "Mustang", 55000, LocalDate.of(2020, 8, 20), 4),
            new Bike("B001", "Yamaha", "R15", 1500, LocalDate.of(2023, 1, 5), 155),
            new Bike("B002", "Kawasaki", "Ninja", 12000, LocalDate.of(2022, 6, 10), 200));

    private static Map<Customer, Set<Vehicle>> salesData = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- AutoDrive Management System ---");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Search Vehicles by Brand");
            System.out.println("3. Add Customer and Purchase Vehicle");
            System.out.println("4. View All Sales Data");
            System.out.println("5. Serialize Sales Data");
            System.out.println("6. Deserialize Sales Data");
            System.out.println("7. Print All Purchased Vehicles Sorted by Price (Descending)");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    // View All Vehicles
                    System.out.println("\n--- Vehicle Inventory ---");
                    for (Vehicle vehicle : inventory) {
                        System.out.println(vehicle);
                    }
                    break;
                case 2:
                    // Search Vehicles by Brand
                    System.out.print("Enter brand to search: ");
                    String brand = scanner.nextLine();
                    List<Vehicle> results = inventory.stream()
                            .filter(new Predicate<Vehicle>() {
                                @Override
                                public boolean test(Vehicle vehicle) {
                                    return vehicle.getBrand().equalsIgnoreCase(brand);
                                }
                            })
                            .collect(Collectors.toList());
                    if (results.isEmpty()) {
                        System.out.println("No vehicles found for brand: " + brand);
                    } else {
                        for (Vehicle vehicle : results) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case 3:
                    // Add Customer and Purchase Vehicle
                    try {
                        System.out.print("Enter customer ID: ");
                        String customerId = scanner.nextLine();
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter customer email: ");
                        String email = scanner.nextLine();

                        Customer customer = new Customer(customerId, name, email);

                        System.out.print("Enter vehicle ID to purchase: ");
                        String vehicleId = scanner.nextLine();
                        Vehicle vehicle = inventory.stream()
                                .filter(new Predicate<Vehicle>() {
                                    @Override
                                    public boolean test(Vehicle v) {
                                        return v.getVehicleId().equals(vehicleId);
                                    }
                                })
                                .findFirst()
                                .orElseThrow(new Supplier<VehicleNotAvailableException>() {
                                    @Override
                                    public VehicleNotAvailableException get() {
                                        return new VehicleNotAvailableException("Vehicle not available!");
                                    }
                                });

                        customer.addPurchasedVehicle(vehicle);
                        salesData.computeIfAbsent(customer, new Function<Customer, Set<Vehicle>>() {
                            @Override
                            public Set<Vehicle> apply(Customer customer) {
                                return new HashSet<>();
                            }
                        }).add(vehicle);
                        inventory.remove(vehicle);
                        System.out.println("Purchase successful!");
                    } catch (VehicleNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    // View All Sales Data
                    System.out.println("\n--- Sales Data ---");
                    for (Map.Entry<Customer, Set<Vehicle>> entry : salesData.entrySet()) {
                        System.out.println(entry.getKey());
                        System.out.println("Vehicles Purchased:");
                        for (Vehicle vehicle : entry.getValue()) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case 5:
                    // Serialize Sales Data
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salesData.ser"))) {
                        oos.writeObject(salesData);
                        System.out.println("Sales data serialized successfully!");
                    }
                    catch (IOException e) {
                        System.out.println("Error serializing sales data: " + e.getMessage());
                    }
                    break;
                case 6:
                    // Deserialize Sales Data
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("salesData.ser"))) {
                        salesData = (Map<Customer, Set<Vehicle>>) ois.readObject();
                        System.out.println("Sales data deserialized successfully!");
                    }
                    catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error deserializing sales data: " + e.getMessage());
                    }
                    break;
                case 7:
                    // Print All Purchased Vehicles Sorted by Price (Descending)
                    List<Vehicle> allPurchasedVehicles = salesData.values().stream()
                            .flatMap(vehicleSet-> {

                                    return vehicleSet.stream();
                                }
                            )
                            .collect(Collectors.toList());

                    allPurchasedVehicles.sort(new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle v1, Vehicle v2) {
                            return Double.compare(v2.getPrice(), v1.getPrice());
                        }
                    });

                    System.out.println("\n--- All Purchased Vehicles Sorted by Price (Descending) ---");
                    for (Vehicle vehicle : allPurchasedVehicles) {
                        System.out.println(vehicle);
                    }
                    break;
                case 8:
                    // Exit the program
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}


