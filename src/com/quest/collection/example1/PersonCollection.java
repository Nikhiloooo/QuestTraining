package com.quest.collection.example1;

import java.util.*;

public class PersonCollection {
    public static void main(String[] args) {


        Person p1 = new Person(1, "Alice", 75);
        Person p2 = new Person(2, "Bob", 30);
        Person p3 = new Person(3, "Charlie", 35);


        Student1 s1 = new Student1("Alice", 85);
        Student1 s2 = new Student1("Bob", 92);
        Student1 s3 = new Student1("Charlie", 78);
        Student1 s4 = new Student1("Allen", 35);

        Comparator<Student1> test = Comparator.comparing(Student1::getMarks);
        PriorityQueue<Student1> pq = new PriorityQueue<>(test);
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        pq.add(s4);
        pq.forEach(System.out::println);


        ArrayList<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        System.out.println("\nusing arraylist");
        for (Person person : personList) {
            person.setAge(person.getAge() + 1); // Incrementing age by 1
            System.out.println(person);
        }


        HashSet<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);
        System.out.println("\nusing hashset");
        for (Person person : personSet) {
            person.setName(person.getName().toUpperCase()); // Converting name to uppercase
            System.out.println(person);
        }


        HashMap<Integer, Person> personMap = new HashMap<>();
        personMap.put(p1.getId(), p1);
        personMap.put(p2.getId(), p2);
        personMap.put(p3.getId(), p3);

        System.out.println("\nusing hashmap");
        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            entry.getValue().setAge(entry.getValue().getAge() + 2); // Incrementing age by 2
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        PriorityQueue<Person> personQueue = new PriorityQueue<>();
        personQueue.add(p1);
        personQueue.add(p2);
        personQueue.add(p3);

        System.out.println("\nUsing PriorityQueue:");
        while (!personQueue.isEmpty()) {
            Person person = personQueue.poll();
            person.setName(person.getName().toLowerCase());
            System.out.println(person);
        }
    }
}
