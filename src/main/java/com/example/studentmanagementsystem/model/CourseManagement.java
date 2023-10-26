package com.example.studentmanagementsystem.model;

import java.util.ArrayList;
import javafx.collections.*;

/**
 * The type Course management.
 */
public class CourseManagement {
    // Static variables
    private static ArrayList<Course> courses = new ArrayList<>();

    /**
     * Add course course.
     *
     * @param courseName the course name
     * @param courseID   the course id
     * @return the course
     */
// Method to add a new course
    public static Course addCourse(String courseName, String courseID) {
        Course course = new Course(courseName, courseID);
        courses.add(course);
        return course;
    }

    /**
     * Gets course details.
     *
     * @param courseID the course id
     * @return the course details
     */
// Method to retrieve course details by ID
    public static Course getCourseDetails(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;  // Or consider throwing an exception if not found
    }

    /**
     * Gets courses.
     *
     * @return the courses
     */
// Method to retrieve all courses
    public static ObservableList<Course> getCourses() {
        return FXCollections.observableArrayList(courses);
    }

    /**
     * Enroll student in course.
     *
     * @param student the student
     * @param course  the course
     */
// Method to enroll a student in a course
    public static void enrollStudentInCourse(Student student, Course course) {
        course.enrollStudent(student);
    }
}
