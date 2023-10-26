package com.example.studentmanagementsystem.model;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Course.
 */
public class Course {
    // Instance variables
    private String courseName;
    private String courseID;
    private List<Student> enrolledStudents = new ArrayList<>();

    /**
     * Gets enrolled students.
     *
     * @return the enrolled students
     */
// Constructor
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Enroll student.
     *
     * @param student the student
     */
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    /**
     * Instantiates a new Course.
     *
     * @param courseName the course name
     * @param courseID   the course id
     */
    public Course(String courseName, String courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }

    // Getters and Setters
    @Override
    public String toString() {
        return this.courseName;  // or return this.getCourseName(); depending on your implementation
    }

    /**
     * Sets course name.
     *
     * @param courseName the course name
     */
    public void setCourseName(String courseName) { this.courseName = courseName; }

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public String getCourseID() { return courseID; }

    /**
     * Sets course id.
     *
     * @param courseID the course id
     */
    public void setCourseID(String courseID) { this.courseID = courseID; }

    /**
     * Course name property string property.
     *
     * @return the string property
     */
// Property methods for TableView compatibility
    public StringProperty courseNameProperty() {
        return new SimpleStringProperty(courseName);
    }

    /**
     * Course id property string property.
     *
     * @return the string property
     */
    public StringProperty courseIDProperty() {
        return new SimpleStringProperty(courseID);
    }
}
