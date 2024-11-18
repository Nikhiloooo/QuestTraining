package com.quest.practice_vars;

import java.util.Scanner;

public class EmpSalaryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfEmployee = getNumOfEmployee(sc);

        //initializing arrays tro store name,basesalary,monthlysalary,bonus,annualsalary
        String[] names = new String[numOfEmployee];
        int[] baseSalaries = new int[numOfEmployee];
        int[][] monthlySalaries = new int[numOfEmployee][12];
        int[] annualSalaries = new int[numOfEmployee];
        int[] bonuses = new int[numOfEmployee];
        int[] avereageMonthlySalaries = new int[numOfEmployee];

        int totalAverageSalary = 0;


        //taking input from user for the base salary and monthly salaries
        for (int i = 0; i < numOfEmployee; i++) {
            System.out.println("Enter the name of employee " + (i + 1) + ": ");
            names[i] = sc.nextLine();
            baseSalaries[i] = getBaseSalary(sc, names[i]);
            annualSalaries[i] = getMonthlySalaries(sc, monthlySalaries[i]);

            //finding bonus,totalaveragemonthlysalary for one employee
            bonuses[i] = baseSalaries[i] / 10;
            avereageMonthlySalaries[i] = annualSalaries[i] / 12;
            totalAverageSalary = totalAverageSalary + (avereageMonthlySalaries[i]);

        }

        //displaying the details of Employee
        displayDetails(numOfEmployee, names, baseSalaries, monthlySalaries, annualSalaries, avereageMonthlySalaries, bonuses, totalAverageSalary);


    }
// method to get and verify the number of qmployees
    private static int getNumOfEmployee(Scanner sc) {
        int numOfEmployee;
        while (true) {
            //getting number of student from user
            System.out.print("Enter the number of employees: ");

            //handle if user enters other than integer
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                sc.next();

            }
            numOfEmployee = sc.nextInt();
            sc.nextLine();

            if (numOfEmployee >= 1 && numOfEmployee <= 100) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
            }
        }
        return numOfEmployee;
    }


    //method to get the basse salary
    private static int getBaseSalary(Scanner sc, String name) {
        int baseSalary;
        while (true) {
            System.out.println("Enter the base salary for " + name + ": ");
            while(!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer for the base salary.");
                sc.next();
            }
            baseSalary = sc.nextInt();
            if (baseSalary >= 0) {
                break;
            }
            else{
                System.out.println("Invalid input. Please enter a valid integer for the base salary.");
            }

        }
        return baseSalary;
    }

    //method to get the monthly salries
    private static int getMonthlySalaries(Scanner sc, int[] monthlySalaries) {
        int annualSalary = 0;
        for (int j = 0; j < 12; j++) {
            while (true) {
                System.out.println("Enter the salary for month " + (j + 1) + " (0-100000): ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 0 and 100000.");
                    sc.next();
                }
                monthlySalaries[j] = sc.nextInt();
                sc.nextLine();
                if (monthlySalaries[j] >= 0 && monthlySalaries[j] <= 100000) {
                    annualSalary += monthlySalaries[j];
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number between 0 and 100000.");
                }
            }

        }
        return annualSalary;
    }



//method to display the employee details
    private static void displayDetails(int numOfEmployee, String[] names, int[] baseSalaries, int[][] monthlySalaries, int[] annualSalaries, int[] avereageMonthlySalaries, int[] bonuses, int totalAverageSalary) {
        int averageSalaryForAllEmployees;
        System.out.println("\n------------ Employee Salary Report ------------");
        for (int i = 0; i < numOfEmployee; i++) {
            System.out.println("Employee Name: " + names[i]);
            System.out.println("Base Salary :" + baseSalaries[i]);
            System.out.println("Monthly Salary Breakdown :");
            for (int j = 0; j < 12; j++) {
                System.out.println("Month " + (j + 1) + ": " + monthlySalaries[i][j]);

            }
            System.out.println("Total Salary for the year: " + annualSalaries[i]);
            System.out.println("Average Monthly salary: " + avereageMonthlySalaries[i]);
            System.out.println("Bonus: " + bonuses[i]);
            System.out.println();
        }


        //finding average salary of total
        averageSalaryForAllEmployees = totalAverageSalary / numOfEmployee;
        System.out.println("Average salary for All Employees: " + averageSalaryForAllEmployees);
        System.out.println("\nThank you for using the Employee Salary Management System.");
    }
}
