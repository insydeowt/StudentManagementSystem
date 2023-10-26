package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.CourseManagement;
import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.Course;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * The type Enroll student controller.
 */
public class EnrollStudentController {

    @FXML
    private ComboBox<Student> studentComboBox;

    @FXML
    private ComboBox<Course> courseComboBox;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        // Populate the studentComboBox with the list of students
        studentComboBox.setItems(FXCollections.observableArrayList(StudentManagement.getStudents()));

        // Populate the courseComboBox with the list of courses
        courseComboBox.setItems(FXCollections.observableArrayList(CourseManagement.getCourses()));
    }

    /**
     * Handle enroll.
     */
    @FXML
    public void handleEnroll() {
        // logic to enroll the selected student in the selected course
        // get the selected student and course
        Student selectedStudent = studentComboBox.getSelectionModel().getSelectedItem();
        Course selectedCourse = courseComboBox.getSelectionModel().getSelectedItem();

        // enroll the student in the course
        if (selectedStudent != null && selectedCourse != null) {
            selectedStudent.enrollInCourse(selectedCourse);

            // Show success alert
            showAlert(Alert.AlertType.INFORMATION, "Enrollment Successful", "Student has been successfully enrolled in the course.");

            // Close the dialog box after enrollment
            closeCurrentWindow();

        } else {
            // Show error alert
            showAlert(Alert.AlertType.ERROR, "Enrollment Error", "Failed to enroll the student. Please ensure both student and course are selected.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();  // This makes the alert modal
    }

    private void closeCurrentWindow() {
        Stage stage = (Stage) studentComboBox.getScene().getWindow();
        stage.close();
    }
}
