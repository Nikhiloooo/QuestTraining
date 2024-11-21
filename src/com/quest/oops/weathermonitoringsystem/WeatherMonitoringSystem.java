package com.quest.oops.weathermonitoringsystem;
import java.util.Scanner;
public class WeatherMonitoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherOperations system = new CityWeatherData(10);

        while (true) {
            System.out.println("\n--- Weather Monitoring System ---");
            System.out.println("1. Add CityWeather");
            System.out.println("2. Update Cityweather");
            System.out.println("3. Display All Cities");
            System.out.println("4. Display City by Name");
            System.out.println("5. Display Extremes");
            System.out.println("6. Display High Humidity Cities");
            System.out.println("7. Display Alerts");
            System.out.println("8. Display Cities Grouped by Weather Condition");
            System.out.println("9. Calculate Average Temperature");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter City Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Temperature: ");
                    double temperature = scanner.nextDouble();
                    System.out.print("Enter Humidity: ");
                    int humidity = scanner.nextInt();
                    System.out.print("Enter Condition: ");
                    String condition = scanner.next();
                    system.addCity(name, temperature, humidity, condition);
                    break;
                case 2:
                    System.out.print("Enter City Name: ");
                    name = scanner.next();
                    System.out.print("Enter New Temperature: ");
                    temperature = scanner.nextDouble();
                    System.out.print("Enter New Humidity: ");
                    humidity = scanner.nextInt();
                    System.out.print("Enter New Condition: ");
                    condition = scanner.next();
                    system.updateCity(name, temperature, humidity, condition);
                    break;
                case 3:
                    system.displayAllCities();
                    break;
                case 4:
                    System.out.print("Enter City Name: ");
                    name = scanner.next();
                    system.displayCity(name);
                    break;
                case 5:
                    system.displayExtremes();
                    break;
                case 6:
                    system.displayHighHumidityCities();
                    break;
                case 7:
                    system.displayAlerts();
                    break;
                case 8:
                    system.displayCitiesByCondition();
                    break;
                case 9:
                    system.displayAverageTemperature();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
