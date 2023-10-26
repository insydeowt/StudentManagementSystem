package com.example.studentmanagementsystem.model;

import java.util.ArrayList;
import javafx.collections.*;

/**
 * The type Student management.
 */
// Student Management class definition
public class StudentManagement {
    // private static variables
    private static ArrayList<Student> students = new ArrayList<>();
    private static int totalStudents = 0;

    /**
     * Add student student.
     *
     * @param name  the name
     * @param ID    the id
     * @param age   the age
     * @param grade the grade
     * @return the student
     */
// static method to add new students
    public static Student addStudent(String name, String ID, int age, String grade) {
        Student student = new Student(name, ID, age, grade);
        students.add(student);
        totalStudents++;
        return student;
    }

    /**
     * Update student.
     *
     * @param ID       the id
     * @param newName  the new name
     * @param newAge   the new age
     * @param newGrade the new grade
     */
// static method to update student information
    public static void updateStudent(String ID, String newName, int newAge, String newGrade) {
        for (Student student : students) {
            if (student.getID().equals(ID)) {
                student.setName(newName);
                student.setAge(newAge);
                student.setGrade(newGrade);
                return ;
            }
        }
        System.out.println("Student ID not found.");
    }

    /**
     * Gets student details.
     *
     * @param ID the id
     * @return the student details
     */
// static method to retrieve student details
    public static Student getStudentDetails(String ID) {
        for (Student student : students) {
            if (student.getID().equals(ID)) {
                return student;
            }
        }
        return null;  // Or consider throwing an exception
    }

    /**
     * Gets students.
     *
     * @return the students
     */
    public static ObservableList<Student> getStudents() {
        return FXCollections.observableArrayList(students);
    }
}

