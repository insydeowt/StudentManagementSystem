package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.controller.MainController;
import com.example.studentmanagementsystem.model.Student;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;


public class UpdateStudentController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    // ... other fields ...

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
        // ... fill other fields ...
    }

    @FXML
    public void handleUpdate() {
        // Get updated data from fields:
        String updatedName = nameField.getText();
        String updatedId = idField.getText();
        // ... get other fields ...

        // Update the student data:
        selectedStudent.setName(updatedName);
        selectedStudent.setID(updatedId);
        // ... update other attributes ...

        // Close the update form:
        ((Stage) nameField.getScene().getWindow()).close();
    }

    @FXML
    public void handleCancel() {
        // Close the update form without saving changes:
        ((Stage) nameField.getScene().getWindow()).close();
    }
}
