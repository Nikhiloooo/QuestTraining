package com.quest.exception_handiling.checked_unchecked;

public class StudentManagement extends Student{

    public StudentManagement(String[] studentNames, String courseName) {
        super(studentNames, courseName);
    }


    public String getStudentByIndex(int index) {
        return getStudentNames()[index];
    }

    public int getCourseNameLength() {
        return getCourseName().length();
    }
}
