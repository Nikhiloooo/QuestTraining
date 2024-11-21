package com.quest.oops.weathermonitoringsystem;

public class CityWeather {
    private String name;
    private double currentTemperature;
    private int humidity;
    private String condition;

    public CityWeather(String name, double currentTemperature, int humidity, String condition) {
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "City: " + name + ", Temperature: " + currentTemperature + "°C, Humidity: " + humidity + "%, Condition: " + condition;
    }
}
