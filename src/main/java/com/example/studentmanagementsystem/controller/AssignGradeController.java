package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Course;
import com.example.studentmanagementsystem.model.CourseManagement;
import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AssignGradeController {

    @FXML
    private ComboBox<Student> studentComboBox;
    @FXML
    private ComboBox<Course> courseComboBox;
    @FXML
    private TextField gradeField;

    @FXML
    private void initialize() {
        studentComboBox.setItems(FXCollections.observableArrayList(StudentManagement.getStudents()));
        courseComboBox.setItems(FXCollections.observableArrayList(CourseManagement.getCourses()));
    }

    @FXML
    public void handleSubmit() {
        Student selectedStudent = studentComboBox.getSelectionModel().getSelectedItem();
        Course selectedCourse = courseComboBox.getSelectionModel().getSelectedItem();
        String grade = gradeField.getText();

        if (selectedStudent != null && selectedCourse != null && !grade.isEmpty()) {
            selectedStudent.setGradeForCourse(selectedCourse, grade);
            // Optionally: Show a confirmation message
        }
    }
}
