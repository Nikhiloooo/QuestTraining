package com.quest.practice_vars;
import java.util.Scanner;
public class StudentMarks {
     static final int MAX_SCORE = 100;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numberOfStudents ;
        //checking the number of student is in the range from 1 to 100   other wise   ask the user to giev valid number
        while (true) {
            //getting number of student from user
            System.out.print("Enter the number of students (1-100): ");
            numberOfStudents = sc.nextInt();
            if (numberOfStudents >= 1 && numberOfStudents <= 100) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
            }
        }
        sc.nextLine();
        //itrate to each student to get the marks for each subject
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.println("enter the name of student " + i + ":");
            String studentName = sc.nextLine();


            int mathScore = getValidScore(sc, "Math");
            int scienceScore = getValidScore(sc, "Science");
            int englishScore = getValidScore(sc, "English");


            //finding  total score ,average
            int totalScore = mathScore + scienceScore + englishScore;
            double averageScore = totalScore / 3.0;
            String grade = calculateGrade(averageScore);

            System.out.println("Total Score: " + totalScore);
            System.out.println("Average Score: " + averageScore);
            System.out.println("Grade: " + grade);

            // switch case to check the calculated grade condition
            switch (grade) {
                case "A":
                    System.out.println("Excellent performance!");
                    break;
                case "B":
                    System.out.println("Good job, but you can aim higher!");
                    break;
                case "C":
                    System.out.println("You need to put in more effort!");
                    break;
                case "D":
                    System.out.println("Your performance is below expectations. Consider seeking help.");
                    break;
                case "F":
                    System.out.println("Failure. You need significant improvement.");
                    break;
            }


            if (mathScore < 60 || scienceScore < 60 || englishScore < 60) {
                System.out.println("Warning: Needs improvement in individual subjects.");
            }
            if (totalScore < 50) {
                System.out.println("Total score below 50. Stopping further processing.");
                break;
            }
        }
        System.out.println("Summary: " + numberOfStudents + " students processed.");
    }


    //fumction  to enter the score for each subject
    public static int getValidScore(Scanner sc, String subject) {
        int score;
        System.out.print("Enter the score for " + subject +":");
        while (true)
        {
            while(!sc.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                sc.next();
            }
            score = sc.nextInt();
            if (score >= 0 && score <= MAX_SCORE)
            {
                break;
            }
            else
            {
                System.out.println("Invalid score. Please enter a score between 0 and "+MAX_SCORE);
            }
        }
        sc.nextLine();
        return score;
    }

     //calculating grade using if else if
    public static String calculateGrade(double average)
    {
        if (average >= 90)
        {
            return "A";
        } else if (average >= 80)
        {
            return "B";
        }
        else if (average >= 70)
        {
            return "C";
        }
        else if (average >= 60)
        {
            return "D";
        }
        else
        {
            return "F";
        }
    }
}
