package com.quest.collection.practicequestions.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeSearch {
    public static void main(String[] args) {
        Map<Integer,String>  employeeMap = new HashMap<>();
        employeeMap.put(1,"Alex");
        employeeMap.put(2,"Bob");
        employeeMap.put(3,"Charlie");
        employeeMap.put(4,"David");
        employeeMap.put(5,"Eve");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of employees:");
        int id = scanner.nextInt();

        String employee = employeeMap.get(id);
      if(employee != null) {
          System.out.println("The employee is " + employee);

      }
      else {
          System.out.println("Employee not found");
      }

    }
}
