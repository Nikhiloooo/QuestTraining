package com.quest.exception_handiling.checked_unchecked;

public class StudentManagementMain {
    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie"};
        String course = "Computer Science";
        StudentManagement studentSystem = new StudentManagement(students, course);

        try {

            System.out.println("Loading student :");
            studentSystem.loadStudentClass("com.quest.exception_handiling.checked_unchecked.StudentManagement");
            System.out.println("Student class loaded");


            System.out.println("Calculating average marks:");
            double averageMarks = studentSystem.calculateAverageMarks(50, 2);
            System.out.println("Average marks: " + averageMarks);


            System.out.println("Fetching student by index:");
            String studentName = studentSystem.getStudentByIndex(6);
            System.out.println("Student name: " + studentName);

            System.out.println("Fetching course name length:");
            int courseNameLength = studentSystem.getCourseNameLength();
            System.out.println("Course name length: " + courseNameLength);

        }
        catch (ClassNotFoundException e) {
            System.out.println("Checked Exception: Student record class not found."+e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("Unchecked Exception:  division by zero."+e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unchecked Exception: Invalid student index."+e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Unchecked Exception: Course name is not set."+e.getMessage());
        }

        finally {
            System.out.println("Student management  completed.");
        }
    }
}
