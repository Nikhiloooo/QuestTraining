package com.quest.casestudies.serviceCenterBMW;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceBooking {
    private static int uniquevalue=0;
    private final String bookingId;
    private Customer customer;
    private LocalDateTime serviceDate;
    private String serviceType;
    private double cost;

    ServiceBooking( Customer customer, LocalDateTime serviceDate, String serviceType, double cost) {
        bookingId= "B"+(++uniquevalue);
        this.customer = customer;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.cost = cost;
    }

    public static int getUniquevalue() {
        return uniquevalue;
    }

    public static void setUniquevalue(int uniquevalue) {
        ServiceBooking.uniquevalue = uniquevalue;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDateTime serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ServiceBooking{" +
                "bookingId='" + bookingId + '\'' +
                ", customer=" + customer +
                ", serviceDate=" + serviceDate +
                ", serviceType='" + serviceType + '\'' +
                ", cost=" + cost +
                '}';
    }
}
