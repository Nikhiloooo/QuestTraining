package com.quest.practicecase.case1;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDataAnalysis {
    public static void main(String[] args) {
        List<Employee> employee= Arrays.asList(new Employee(1, "Alice", "HR", 60000),
                new Employee(2, "Bob", "Finance", 48000),
                new Employee(3, "Charlie", "HR", 45000),
                new Employee(4, "David", "IT", 75000));

        Map<String,List<Employee>> groupedByDepartment =employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Grouping by department");

        System.out.println("Grouped by Department: " + groupedByDepartment.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream().map(Employee::getName).collect(Collectors.toList()))));


        List<String> filteredEmployees = employee.stream()
                .filter(e -> e.getSalary() > 50000)
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Employees with salary > 50000: " + filteredEmployees);


        Optional<Employee> highestSalaryEmployee = employee.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestSalaryEmployee.ifPresent(e -> System.out.println("Employee with highest salary: " + e.getName()));

        }


    }

