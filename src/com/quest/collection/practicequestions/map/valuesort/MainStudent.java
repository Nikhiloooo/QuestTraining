package com.quest.collection.practicequestions.map.valuesort;

import java.util.*;

public class MainStudent {
    public static void main(String[] args) {
        Student s1=new Student(3,"Nikhil");
        Student s2=new Student(2,"Vishnu");
        Student s3=new Student(5,"Akhila");
        Student s4=new Student(1,"Bibin");
        Student s5=new Student(4,"Aswin");

        Map<Student,Integer> studentMarksMap=new HashMap<>();
        studentMarksMap.put(s1,72);
        studentMarksMap.put(s2,65);
        studentMarksMap.put(s3,82);
        studentMarksMap.put(s4,15);
        studentMarksMap.put(s5,70);

        //sort the above map on the basis  of student's mark( which is value inside the map)
        List<Map.Entry<Student,Integer>> entries=new ArrayList<>();
        for(Map.Entry<Student,Integer> entry:studentMarksMap.entrySet()){
            entries.add(entry);
        }
        StudentMarkComparator studentMarkComparator=new StudentMarkComparator();
        entries.sort(studentMarkComparator);

        studentMarksMap=new LinkedHashMap<>();
        for(Map.Entry<Student,Integer> entry:entries){
            studentMarksMap.put(entry.getKey(),entry.getValue());

        }
        for(Map.Entry<Student,Integer> entry:studentMarksMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }


    }
}
