package com.quest.casestudies.serviceCenterBMW;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ServiceBookingManager {
    private Map<Customer, List<ServiceBooking>> serviceBookingsMap = new HashMap<>();

    // Add ServiceBooking for a Customer
    public void addServiceBooking(Customer customer, ServiceBooking booking) throws InvalidBookingException {
        if (serviceBookingsMap.containsKey(customer)) {
            for (ServiceBooking existingBooking : serviceBookingsMap.get(customer)) {
                if (existingBooking.getBookingId().equals(booking.getBookingId())) {
                    throw new InvalidBookingException("Booking ID already exists.");
                }
            }
        } else {
            serviceBookingsMap.put(customer, new ArrayList<>());
        }

        if (booking.getServiceDate().isBefore(LocalDateTime.now())) {
            throw new InvalidBookingException("Service date cannot be in the past.");
        }
        serviceBookingsMap.get(customer).add(booking);

    }

    // Predicate: Check if a service is within the next 7 days
    public static Predicate<ServiceBooking> isBookingInNext7Days = booking -> {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sevenDaysLater = now.plusDays(7);

        // Check if the service booking date is within the next 7 days
        return booking.getServiceDate().isAfter(now) && booking.getServiceDate().isBefore(sevenDaysLater);
    };

    //print invoice
    public Consumer<Customer> printInvoice = customer -> {
        List<ServiceBooking> bookings = serviceBookingsMap.get(customer);
        double totalCost = 0;
        System.out.println("Invoice for " + customer.getName() + ":");
        for (ServiceBooking booking : bookings) {
            System.out.println(booking);
            totalCost += booking.getCost();
        }
        System.out.println("Total cost: " + totalCost);
    };


    //15% discount
    public Function<Customer, Double> applyDiscount = customer -> {
        List<ServiceBooking> bookings = serviceBookingsMap.get(customer);
        if (bookings != null && bookings.size() > 3) {
            return bookings.stream()
                    .mapToDouble(ServiceBooking::getCost)
                    .sum() * 0.85; // 15% discount
        }
        return bookings != null ? bookings.stream().mapToDouble(ServiceBooking::getCost).sum() : 0;
    };

    // Supplier to generate random service booking
    public Supplier<ServiceBooking> randomServiceBookingSupplier() {
        return () -> {
            Customer customer = new Customer("John Doe", "john@example.com", new ElectricVehicle("EV1234", "BMW", 2022, 15, "John", 75.0, 350));
            LocalDateTime serviceDate = LocalDateTime.now().plusDays(new Random().nextInt(10));
            String serviceType = "Battery Check";
            double cost = 100.0 + new Random().nextDouble() * 50.0;
            return new ServiceBooking(customer, serviceDate, serviceType, cost);
        };
    }

    public Map<Customer,List<ServiceBooking>> getServiceBookingsMap() {
        return serviceBookingsMap;
    }

}
