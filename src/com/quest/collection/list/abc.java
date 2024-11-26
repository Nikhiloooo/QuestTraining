package com.quest.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

public class abc {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();

        list.add(new Person("nik",21));
        list.add(new Person("bib",20));
        list.add(new Person("aka",19));
        list.add(new Person("san",27));
        int a=list.get(1).getAge();
        String s1=list.get(1).getName();
        System.out.println(a);
        System.out.println(s1);

//        for(Person person:list){
//            System.out.println(person.getAge()+" : "+person.getName());
//        }
        for(Person person:list){
            if(person.getAge()<20){
//                System.out.println(person.getName()+" : "+person.getAge());
            }
        }

        Iterator<Person> iterator = list.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.getAge()<20){
                System.out.println(person.getName());
                System.out.println(person.getAge());
            }
        }



        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        for(int integer:list1){
            System.out.println(integer);
        }

    }
}
