package com.quest.collection.practicequestions.map.valuesort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e1=new Employee(2,"Nikhil",23);
        Employee e2=new Employee(4,"Sooraj",27);
        Employee e3=new Employee(1,"Amiga",21);
        Employee e4=new Employee(6,"Pranav",25);
        Employee e5=new Employee(3,"Nandu",22);

        Map<Employee,Double> map=new HashMap<Employee,Double>();
        map.put(e1,28000.0);
        map.put(e2,22000.0);
        map.put(e3,23000.0);
        map.put(e4,20000.0);
        map.put(e5,25000.0);

        List<Map.Entry<Employee,Double>> list=new ArrayList<>();
        for(Map.Entry<Employee,Double> entry:map.entrySet()){
            list.add(entry);
        }
        EmployeeSalaryComparator  EmployeeSalaryComparator=new EmployeeSalaryComparator();
        list.sort( EmployeeSalaryComparator);
        for(Map.Entry<Employee,Double> entry:list){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
