package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.CourseManagement;
import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.Course;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class EnrollStudentController {

    @FXML
    private ComboBox<Student> studentComboBox;

    @FXML
    private ComboBox<Course> courseComboBox;

    @FXML
    public void initialize() {
        // Populate the studentComboBox with the list of students
        studentComboBox.setItems(FXCollections.observableArrayList(StudentManagement.getStudents()));

        // Populate the courseComboBox with the list of courses
        courseComboBox.setItems(FXCollections.observableArrayList(CourseManagement.getCourses()));
    }


    @FXML
    public void handleEnroll() {
        // logic to enroll the selected student in the selected course
    }
}
