package com.example.studentmanagementsystem.model;

import java.util.ArrayList;
import javafx.collections.*;

public class CourseManagement {
    // Static variables
    private static ArrayList<Course> courses = new ArrayList<>();

    // Method to add a new course
    public static Course addCourse(String courseName, String courseID) {
        Course course = new Course(courseName, courseID);
        courses.add(course);
        return course;
    }

    // Method to retrieve course details by ID
    public static Course getCourseDetails(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;  // Or consider throwing an exception if not found
    }

    // Method to retrieve all courses
    public static ObservableList<Course> getCourses() {
        return FXCollections.observableArrayList(courses);
    }
}
