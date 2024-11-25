package com.quest.exception_handiling.exception1;

import java.util.InputMismatchException;
import java.util.Scanner;

class ExceptionHandlerSub {
    public int divideNumbers(int num1, int num2) throws ArithmeticException {
        return num1 / num2;
    }

    public int accessArrayElement(int[] array, int index) throws ArrayIndexOutOfBoundsException, NullPointerException {
        int value = array[index];
        if (value == 0) {
            throw new NullPointerException("Accessed value in the array is 0, treated as null.");
        }
        return value;
    }
}

public class ExceptionHandler {
    public static void main(String[] args) {
        ExceptionHandlerSub ex = new ExceptionHandlerSub();
        Scanner sc = new Scanner(System.in);
        int[] array = {10, 20, 0, 40, 50}; // Array of size 5 (0 included for testing)

        try {
            System.out.print("Enter the first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = sc.nextInt();

            System.out.print("Enter an array index (0-4): ");
            int index = sc.nextInt();

            // Division
            int result = ex.divideNumbers(num1, num2);
            System.out.println("Division result: " + result);

            // Access array element
            int element = ex.accessArrayElement(array, index);
            System.out.println("Array element at index " + index + ": " + element);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numeric values only.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds. Please enter a valid index (0-4).");
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Exception handling is complete.");
            sc.close();
        }
    }
}
