package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
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
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }



    @FXML
    private void handleSave() {
        String name = nameField.getText();
        String id = idField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();

        Student newStudent = StudentManagement.addStudent(name, id, age, grade);
        if (mainController != null) {
            mainController.addStudent(newStudent);
        }

        if (dialogStage != null) {
            dialogStage.close();
        } else {
            System.err.println("Dialog stage is not initialized.");
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    public void setDialogStage(Stage dialogStage) {
    }
}
