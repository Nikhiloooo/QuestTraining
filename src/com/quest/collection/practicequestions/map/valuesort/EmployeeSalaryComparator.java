package com.quest.collection.practicequestions.map.valuesort;

import java.util.Comparator;
import java.util.Map;

public class EmployeeSalaryComparator implements Comparator<Map.Entry<Employee, Double>> {
    @Override
    public int compare(Map.Entry<Employee, Double> o1, Map.Entry<Employee, Double> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}
