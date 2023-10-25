package com.example.studentmanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCourseController {

    @FXML
    private TextField courseNameField;

    @FXML
    private TextField courseIDField;

    private Stage dialogStage;

    @FXML
    private void handleSave() {
        String courseName = courseNameField.getText();
        String courseID = courseIDField.getText();

        // TODO: Add the course to the system using courseName and courseID

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
}
