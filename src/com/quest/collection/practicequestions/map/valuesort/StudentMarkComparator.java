package com.quest.collection.practicequestions.map.valuesort;

import java.util.Comparator;
import java.util.Map;

public class StudentMarkComparator implements Comparator<Map.Entry<Student,Integer>> {

    @Override
    public int compare(Map.Entry<Student, Integer> o1, Map.Entry<Student, Integer> o2) {

         return o1.getValue().compareTo(o2.getValue());
    }
}
