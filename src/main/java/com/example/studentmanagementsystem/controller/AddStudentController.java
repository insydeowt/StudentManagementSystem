package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * The type Add student controller.
 */
public class AddStudentController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField gradeField;

    private Stage dialogStage;
    private MainController mainController;

    /**
     * Sets main controller.
     *
     * @param mainController the main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleSave() {
        String name = nameField.getText();
        String id = idField.getText();
        String ageStr = ageField.getText();
        String grade = gradeField.getText();

        if (name != null && !name.trim().isEmpty() &&
                id != null && !id.trim().isEmpty() &&
                ageStr != null && !ageStr.trim().isEmpty() &&
                grade != null && !grade.trim().isEmpty()) {

            int age = Integer.parseInt(ageStr); // Might throw an exception for non-numeric input
            Student newStudent = StudentManagement.addStudent(name, id, age, grade);

            if (mainController != null) {
                mainController.addStudent(newStudent);
            }

            // Show success alert
            showAlert(Alert.AlertType.INFORMATION, "Add Student Successful", "Student has been successfully added.");

            // Close the dialog box after addition
            closeCurrentWindow();

        } else {
            // Show error alert
            showAlert(Alert.AlertType.ERROR, "Add Student Error", "Failed to add the student. Please ensure all fields are correctly filled.");
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

    /**
     * Sets dialog stage.
     *
     * @param dialogStage the dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
