package com.quest.oops.weathermonitoringsystem;

public abstract class WeatherOperations {

    protected CityWeather[] cities;
    protected int cityCount;

    public WeatherOperations(int maxCities) {
        cities = new CityWeather[maxCities];
        cityCount = 0;
    }

    public abstract void addCity(String name,double currentTemprature,int humidity,String condition);
    public abstract void updateCity(String name, double currentTemperature, int humidity, String condition);
    public abstract void displayAllCities();
    public abstract void displayCity(String name);
    public abstract void displayExtremes();
    public abstract void displayHighHumidityCities();
    public abstract void displayAlerts();
    public  abstract void displayCitiesByCondition();public abstract void displayAverageTemperature();

}
