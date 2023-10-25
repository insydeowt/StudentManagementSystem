package com.example.studentmanagementsystem.model;

import javafx.beans.property.*;

public class Course {
    // Instance variables
    private String courseName;
    private String courseID;

    // Constructor
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
