package com.quest.exception_handiling.exception_employee;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ManageEmployee {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        Employee employee = null;
        Manager manager = null;

        while (employee == null) {
            try {
                System.out.println("Enter Employee details:");
                System.out.print("Name: ");
                String empName = sc.nextLine();
                System.out.print("Age: ");
                int empAge = sc.nextInt();
                System.out.print("Salary: ");
                double empSalary = sc.nextDouble();
                sc.nextLine(); // Consume newline

                employee = new Employee(empName, empAge, empSalary);
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: Please enter the correct data type.");
                sc.nextLine(); // Clear invalid input
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage() + " Please re-enter details.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Please re-enter details.");
            }
        }

        while (manager == null) {
            try {
                System.out.println("Enter Manager details:");
                System.out.print("Name: ");
                String mgrName = sc.nextLine();
                System.out.print("Age: ");
                int mgrAge = sc.nextInt();
                System.out.print("Salary: ");
                double mgrSalary = sc.nextDouble();
                System.out.print("Team Size: ");
                int mgrTeamSize = sc.nextInt();
                sc.nextLine(); // Consume newline

                manager = new Manager(mgrName, mgrAge, mgrSalary, mgrTeamSize);
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: Please enter the correct data type.");
                sc.nextLine(); // Clear invalid input
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage() + " Please re-enter details.");
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException: " + e.getMessage() + " Please re-enter details.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Please re-enter details.");
            }
        }


        System.out.println("Employee Details");
        System.out.println(employee.toString());

        System.out.println("Manager Details");
        System.out.println(manager.toString());;
 }
}
