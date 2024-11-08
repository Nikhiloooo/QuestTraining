package com.quest.practice_vars;

public class PracticeVars {

    public static void main(String[] args)
    {
        final  int VOTE_AGE=18;
        int age=18;
        double salary=1000.00;
        char gender='M';
        String firstName="John";
        String lastName="Doe";

        System.out.println("age = "+age);
        System.out.println("salary = "+salary);
        System.out.println("gender = "+gender);
        System.out.println("firstName = "+firstName);
        System.out.println("lastName = "+lastName);

        age=20;
        System.out.println("age = "+age);
        System.out.println("vote age ="+VOTE_AGE);
//        VOTE_AGE=20; it cannot be change because VOTE_AGE is final

      practiceConversion();
        stringConcatenation();
      stringMethods();
    }

    private static void practiceConversion()
    {
        int a=20;
        double b=25.5;
        double sum=a+b;
        int round=(int)b;
        System.out.println("sum = "+sum);
        System.out.println("round = "+round);

    }
    private static void stringConcatenation()
    {
        String s1="John";
        String s2="Doe";
        String s3=s1+" "+s2;
        System.out.println(s3);
        int age=20;
        System.out.println("name = "+s3+" age = "+age);
    }
    private static void stringMethods()
    {
        String s1="John";
        String s2="JOHN";
        String s4=new String("Hello world");
        String s3=new String("Hello world");
        System.out.println(s3.length());
        System.out.println(s3.equalsIgnoreCase(s2));
        System.out.println(s3.equals(s2));
        System.out.println(s4==s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(s4.charAt(1));//charater at the given index
        System.out.println(s4.indexOf('e',0)); //index of the number
        String sub=s4.substring(1,4);//substring
        System.out.println(sub);
        boolean hasele=s3.contains("ell");  //check if the substring present in it
        System.out.println(hasele);
        String lower=s2.toLowerCase();   //lowercasing
        System.out.println(lower);
        String upper=s1.toUpperCase();   //uppercasing
        System.out.println(upper);
        System.out.println(s4.replace('e','a'));    //replace charater
        String val=String.valueOf(123);   //return string representation of object
        System.out.println(val);
        System.out.println(s1.isEmpty());
        System.out.println(s3.startsWith("Hel"));   //check the string start with
        System.out.println(s3.endsWith("ld"));    //checks the string end with
        System.out.println(s3.compareTo(s4));
        String  s5="       hello world    ";
        String trim=s3.trim();
        System.out.println(trim);
        System.out.println(s1.concat(s3));  //concating the 2 string
        System.out.println(s1.hashCode());
        String[] str=s3.split(" ");
       for( String s:str)
       {
           System.out.println(s);
       }
    }

}
