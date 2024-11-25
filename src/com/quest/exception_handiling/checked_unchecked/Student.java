package com.quest.exception_handiling.checked_unchecked;

public class Student {
    private final String[] studentNames;
    private final String courseName;

    public Student(String[] studentNames, String courseName) {
        this.studentNames = studentNames;
        this.courseName = courseName;
    }

    public String[] getStudentNames() {
        return studentNames;
    }

    public String getCourseName() {
        return courseName;
    }

    public void loadStudentClass(String className) throws ClassNotFoundException {
        Class.forName(className);
    }

    public double calculateAverageMarks(int totalMarks, int subjects) {
        if (subjects == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) totalMarks / subjects;
    }
}


