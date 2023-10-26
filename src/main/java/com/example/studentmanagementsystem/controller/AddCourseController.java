package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Course;
import com.example.studentmanagementsystem.model.CourseManagement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCourseController {

    @FXML
    private TextField courseNameField;

    @FXML
    private TextField courseIDField;

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleSave() {
        String courseName = courseNameField.getText();
        String courseID = courseIDField.getText();

        if (courseName != null && !courseName.trim().isEmpty() && courseID != null && !courseID.trim().isEmpty()) {
            // Add the course using CourseManagement
            CourseManagement.addCourse(courseName, courseID);

            // Show success alert
            showAlert(Alert.AlertType.INFORMATION, "Add Course Successful", "Course has been successfully added.");

            // Close the dialog box after addition
            closeCurrentWindow();

        } else {
            // Show error alert
            showAlert(Alert.AlertType.ERROR, "Add Course Error", "Failed to add the course. Please ensure all fields are correctly filled.");
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();  // This makes the alert modal
    }

    private void closeCurrentWindow() {
        if (dialogStage != null) {
            dialogStage.close();
        } else {
            System.err.println("Dialog stage is not initialized.");
        }
    }
}
