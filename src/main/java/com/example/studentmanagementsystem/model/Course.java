package com.example.studentmanagementsystem.model;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Course {
    // Instance variables
    private String courseName;
    private String courseID;
    private List<Student> enrolledStudents = new ArrayList<>();

    // Constructor
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }
    public Course(String courseName, String courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }

    // Getters and Setters
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    // Property methods for TableView compatibility
    public StringProperty courseNameProperty() {
        return new SimpleStringProperty(courseName);
    }

    public StringProperty courseIDProperty() {
        return new SimpleStringProperty(courseID);
    }
}
