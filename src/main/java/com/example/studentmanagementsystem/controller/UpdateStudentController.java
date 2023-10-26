package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.controller.MainController;
import com.example.studentmanagementsystem.model.Student;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class UpdateStudentController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField ageField;

    private Student selectedStudent;
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setSelectedStudent(Student student) {
        this.selectedStudent = student;
        // Pre-fill the fields:
        nameField.setText(student.getName());
        idField.setText(student.getID());
        ageField.setText(String.valueOf(student.getAge()));
    }

    @FXML
    public void handleUpdate() {
        // Get updated data from fields:
        String updatedName = nameField.getText();
        String updatedId = idField.getText();
        String ageStr = ageField.getText();

        if (updatedName != null && !updatedName.trim().isEmpty() &&
                updatedId != null && !updatedId.trim().isEmpty() &&
                ageStr != null && !ageStr.trim().isEmpty()) {

            try {
                int updatedAge = Integer.parseInt(ageStr);
                selectedStudent.setName(updatedName);
                selectedStudent.setID(updatedId);
                selectedStudent.setAge(updatedAge);

                // Update the student data in the main controller and refresh the table:
                mainController.updateStudent(selectedStudent);

                // Show success alert
                showAlert(Alert.AlertType.INFORMATION, "Update Successful", "Student data has been successfully updated.");

                // Close the update form:
                closeCurrentWindow();
            } catch (NumberFormatException e) {
                // Show error alert for invalid age input
                showAlert(Alert.AlertType.ERROR, "Update Error", "Invalid age input. Please enter a valid number.");
            }

        } else {
            // Show error alert
            showAlert(Alert.AlertType.ERROR, "Update Error", "Failed to update the student. Please ensure all fields are correctly filled.");
        }
    }

    @FXML
    public void handleCancel() {
        // Close the update form without saving changes:
        closeCurrentWindow();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();  // This makes the alert modal
    }

    private void closeCurrentWindow() {
        ((Stage) nameField.getScene().getWindow()).close();
    }
}
