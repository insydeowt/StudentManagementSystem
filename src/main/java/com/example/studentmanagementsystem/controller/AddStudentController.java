package com.example.studentmanagementsystem.controller;


import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import javafx.stage.Stage;

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

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleSave() {
        String name = nameField.getText();
        String id = idField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();

        StudentManagement.addStudent(name, id, age, grade);

        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    public void handleSubmitButtonAction() {
        String name = nameField.getText();
        String id = idField.getText();
        int age = Integer.parseInt(ageField.getText());  // Ensure age is an integer before parsing
        String grade = gradeField.getText();

        StudentManagement.addStudent(name, id, age, grade);
    }
}

