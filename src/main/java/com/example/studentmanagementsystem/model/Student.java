package com.example.studentmanagementsystem.model;
import javafx.beans.property.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Student.
 */
// Student class definition
public class Student {
    /**
     * The Name.
     */
// private instance variables
    public String name;
    private String ID;
    private int age;
    private String grade;

    private Map<Course, String> courseGrades;


    /**
     * Instantiates a new Student.
     *
     * @param name  the name
     * @param ID    the id
     * @param age   the age
     * @param grade the grade
     */
// public constructor
    public Student(String name, String ID, int age, String grade) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.grade = grade;
        this.courseGrades = new HashMap<>();
    }

    // public get and set methods
    @Override
    public String toString() {
        return this.name;  // or return this.getStudentName(); depending on your implementation
    }

    /**
     * Sets grade for course.
     *
     * @param course the course
     * @param grade  the grade
     */
    public void setGradeForCourse(Course course, String grade) {
        this.courseGrades.put(course, grade);
    }

    /**
     * Gets grade for course.
     *
     * @param course the course
     * @return the grade for course
     */
    public String getGradeForCourse(Course course) {
        return this.courseGrades.getOrDefault(course, "N/A");  // N/A if no grade is set for the course
    }

    /**
     * Gets all grades.
     *
     * @return the all grades
     */
    public Map<Course, String> getAllGrades() {
        return Collections.unmodifiableMap(this.courseGrades);
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getID() { return ID; }

    /**
     * Sets id.
     *
     * @param ID the id
     */
    public void setID(String ID) { this.ID = ID; }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() { return age; }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public String getGrade() { return grade; }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(String grade) { this.grade = grade; }

    /**
     * Name property string property.
     *
     * @return the string property
     */
    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    /**
     * Id property string property.
     *
     * @return the string property
     */
    public StringProperty idProperty() {
        return new SimpleStringProperty(ID);
    }

    /**
     * Age property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty ageProperty() {
        return new SimpleIntegerProperty(age);
    }

    /**
     * Grade property string property.
     *
     * @return the string property
     */
    public StringProperty gradeProperty() {
        return new SimpleStringProperty(grade);
    }

    /**
     * Enroll in course.
     *
     * @param course the course
     */
    public void enrollInCourse(Course course) {
        // Assuming that you want to add the course to the courseGrades map with a default grade (e.g., "N/A")
        if (!this.courseGrades.containsKey(course)) {
            this.courseGrades.put(course, "N/A");
        } else {
            // Optional: Handle the case where the student is already enrolled in the course
            System.out.println("Student is already enrolled in this course.");
        }
    }

}

