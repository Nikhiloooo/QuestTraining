package com.quest.stream.employee;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class EmployeeStreamOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 30, "IT", 60000, 5),
                new Employee(2, "Bob", 35, "HR", 55000, 7),
                new Employee(3, "Charlie", 28, "IT", 70000, 4),
                new Employee(4, "David", 40, "Finance", 80000, 10),
                new Employee(5, "Eve", 25, "IT", 45000, 2));



        List<Employee> sortedBySalary = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))
                .collect(Collectors.toList());
        System.out.println("Sorted by salary: " + sortedBySalary);


        // Filtering by department
        List<Employee> itDepartmentEmployees = employees.stream()
                .filter(emp -> "IT".equals(emp.getDepartment()))
                .collect(Collectors.toList());
        System.out.println("IT Department Employees: " + itDepartmentEmployees);



        // Finding the employee with the maximum salary
        Optional<Employee> maxSalaryEmployee = employees.stream()
                .max((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()));
        maxSalaryEmployee.ifPresent(emp -> System.out.println("Max salary employee: " + emp));



        // Skipping the first 2 employees for pagination
        List<Employee> paginatedEmployees = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Paginated Employees: " + paginatedEmployees);



        // Iterating over employees and printing their details
        employees.stream()
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee emp) {
                        System.out.println(emp.getName() + " works in " + emp.getDepartment());
                    }
                });


        // Collecting employees into a map by department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment()));
        System.out.println("Employees by Department: " + employeesByDepartment);


        // Reducing to compute total salary
        double totalSalary = employees.stream()
                .map(emp -> emp.getSalary())
                .reduce(0.0, (sum, salary) -> sum + salary);
        System.out.println("Total salary: " + totalSalary);



        // Reducing to compute average salary
        double averageSalary = employees.stream()
                .mapToDouble(emp -> emp.getSalary())
                .average()
                .orElse(0.0);
        System.out.println("Average salary: " + averageSalary);

    }
}
