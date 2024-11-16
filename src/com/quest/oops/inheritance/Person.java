package com.quest.oops.inheritance;

public class Person {
      String name;
      int age;
     public Person(String name, int age) {
         this.name = name;
         this.age = age;
     }
     public void nameDisplay()
     {
         String message=String.format("person name is %s and age is %d ",name,age);
         System.out.println(message);
     }

}
