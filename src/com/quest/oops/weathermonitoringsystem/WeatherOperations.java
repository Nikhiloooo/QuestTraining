package com.quest.oops.weathermonitoringsystem;

public interface WeatherOperations {

    void addCity(String name, double currentTemprature, int humidity, String condition);

    void updateCity(String name, double currentTemperature, int humidity, String condition);

    void displayAllCities();

    void displayCity(String name);

    void displayExtremes();

    void displayHighHumidityCities();

    void displayAlerts();

    void displayCitiesByCondition();

    void displayAverageTemperature();

}
