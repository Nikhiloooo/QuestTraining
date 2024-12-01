package com.quest.collection.example2;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class StudentCollection {
    public static void main(String[] args) {

        Student s1=new Student(4,"nik",19);
        Student s2=new Student(2,"Bibn",25);
        Student s3=new Student(1,"akhi",12);
        Student s4=new Student(7,"john",27);
        Student s5=new Student(3,"sanju",26);

        PriorityQueue<Student> studentQueue = new PriorityQueue<>();

        studentQueue.add(s1);
        studentQueue.add(s2);
        studentQueue.add(s3);
        studentQueue.add(s4);
        studentQueue.add(s5);

        System.out.println("Students sorted by ID (natural order):");
        while (!studentQueue.isEmpty()) {
            System.out.println(studentQueue.poll());
        }

    }
}
