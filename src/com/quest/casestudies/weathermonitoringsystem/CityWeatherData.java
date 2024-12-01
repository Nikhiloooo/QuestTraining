package com.quest.casestudies.weathermonitoringsystem;

public class CityWeatherData implements WeatherOperations{

    protected CityWeather[] cities;
    protected int cityCount;

    public CityWeatherData(int maxCities) {
        cities = new CityWeather[maxCities];
        cityCount = 0;
    }


    //method to add the city weather details
    @Override
    public void addCity(String name, double currentTemperature, int humidity, String condition) {
        if (cityCount < cities.length) {
            cities[cityCount++] = new CityWeather(name, currentTemperature, humidity, condition);
        } else {
            System.out.println("Cannot add more cities. Maximum limit reached.");
        }
    }


//method for update details of a particular city
    @Override
    public void updateCity(String name, double currentTemperature, int humidity, String condition) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getName().equalsIgnoreCase(name)) {
                cities[i].setCurrentTemperature(currentTemperature);
                cities[i].setHumidity(humidity);
                cities[i].setCondition(condition);
                System.out.println("Weather updated for " + name);
                return;
            }
        }
        System.out.println("City not found!");
    }

//methods to display all the city with details
    @Override
    public void displayAllCities() {
        System.out.println("Displaying All Cities:");
        for (int i = 0; i < cityCount; i++) {
            System.out.println(cities[i]);

        }
    }

    //method to display details of a particular city by name
    @Override
    public void displayCity(String name) {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getName().equalsIgnoreCase(name)) {
                System.out.println(cities[i]);
                return;
            }
        }
        System.out.println("City not found!");
    }


//method to display the highest and lowest temprature city name
    @Override
    public void displayExtremes() {
        if (cityCount == 0) {
            System.out.println("No data available.");
            return;
        }

        CityWeather highest = cities[0];
        CityWeather lowest = cities[0];
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCurrentTemperature() > highest.getCurrentTemperature()) {
                highest = cities[i];
            }
            if (cities[i].getCurrentTemperature() < lowest.getCurrentTemperature()) {
                lowest = cities[i];
            }
        }
        System.out.println("City with the Highest Temperature: " + highest.getName());
        System.out.println("City with the Lowest Temperature: " + lowest.getName());
    }


    //method to get the city which has humidity greater than 80
    @Override
    public void displayHighHumidityCities() {
        boolean found = false;
        System.out.println("Cities with Humidity > 80%:");
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getHumidity() > 80) {
                System.out.println(cities[i].getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cities found.");
        }
    }


    //method to group the city based on weather condition
@Override
    public void displayCitiesByCondition() {
    System.out.println("Cities Grouped by Weather Condition:");
    String[] conditions = {"Sunny", "Rainy", "Cloudy", "Snowy", "Windy"};
    for (String condition : conditions) {
        System.out.print(condition + ": ");
        boolean found = false;
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCondition().equalsIgnoreCase(condition)) {
                System.out.print(cities[i].getName() + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }

}

//method to display average temprature
@Override
        public void displayAverageTemperature() {
            if (cityCount == 0) {
                System.out.println("No cities to calculate average temperature.");
                return;
            }

            double totalTemperature = 0;
            for (int i = 0; i < cityCount; i++) {
                totalTemperature += cities[i].getCurrentTemperature();
            }

            double averageTemperature = totalTemperature / cityCount;
            System.out.println("Average Temperature Across All Cities: " + averageTemperature + "°C");
        }


        //method to display alert when temprature grater or when humidity is less
    @Override
    public void displayAlerts() {
        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getCurrentTemperature() > 40) {
                System.out.println("Heatwave Alert: " + cities[i].getName() + " is experiencing extreme heat (" + cities[i].getCurrentTemperature() + "°C)!");
            }
            if (cities[i].getHumidity() < 20) {
                System.out.println("Low Humidity Warning: " + cities[i].getName() + " has critically low humidity (" + cities[i].getHumidity() + "%)!");
            }
        }
    }


}
