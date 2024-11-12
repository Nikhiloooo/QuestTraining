package com.quest.practice_vars;
import java.util.Scanner;
public class Calculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double res = getRes(sc);

        System.out.println("current result: " + res);
        boolean continueOperation=true;
        System.out.println();

        while(continueOperation)
        {
            System.out.println("1.Addition\n2.Suntraction \n3.Multiplication\n4.Division\n5.Squareroot\n6.Clear current result \n7.exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            int choice=0;

            while (true)
            {
                if (sc.hasNextInt())
                {
                    choice=sc.nextInt();
                    break;
                }
                else{
                    System.out.println("Invalid input. Please enter a numeric value.");
                    sc.next();
                }


            }
            switch(choice)
            {
                case 1:
                    System.out.println("enter the number to add :");
                    double addnum = sc.nextDouble();
                    res=res+addnum;
                    System.out.println("Current result: " + res);
                    break;

                case 2:
                    System.out.print("Enter the number to subtract: ");
                    double subnum = sc.nextDouble();
                    res= res-subnum;
                    System.out.println("Current result: " + res);
                    break;

                case 3:
                    System.out.print("Enter the number to multiply : ");
                    double mulnum = sc.nextDouble();
                    res =res* mulnum;
                    System.out.println("Current result: " + res);
                    break;

                case 4:
                    System.out.print("Enter the number to divide by: ");
                    double divnum = sc.nextDouble();
                    if (divnum != 0)
                    {
                        res = res/divnum;
                        System.out.println("Current result: " + res);
                    }
                    else
                    {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;

                case 5:
                    if (res >= 0)
                    {
                        res = Math.sqrt(res);
                        System.out.println("Current result: " + res);
                    }
                    else
                    {
                        System.out.println("Error: Cannot take the square root of a negative number.");
                    }
                    break;

                case 6:
                    res = 0;
                    System.out.println("Current result has been reset to zero.");
                    break;

                case 7:
                    continueOperation = false;
                    System.out.println("Exiting the calculator.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            if (continueOperation)
            {
                System.out.print("Do you want to perform another operation? (yes/no): ");
                String response = sc.next();
                if (response.equalsIgnoreCase("no"))
                {
                    continueOperation = false;
                    System.out.println("Exiting the calculator.");
                }
            }
        }
    }

    private static double getRes(Scanner sc) {
        double res = 0;

        // Input for starting number with validation
        while (true) {
            System.out.println("Please enter the starting number: ");
            if (sc.hasNextDouble()) {
                res = sc.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                sc.next(); // Clear the invalid input
            }
        }
        return res;
    }


}
