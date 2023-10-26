package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * The type Student details controller.
 */
public class StudentDetailsController {

    @FXML
    private Label nameLabel, idLabel, ageLabel, gradesLabel, coursesLabel;

    private Stage dialogStage;

    /**
     * Sets student details.
     *
     * @param student the student
     */
    public void setStudentDetails(Student student) {
        nameLabel.setText("Name: " + student.getName());
        idLabel.setText("ID: " + student.getID());
        ageLabel.setText("Age: " + student.getAge());

        // Display the grades and courses for the student
        gradesLabel.setText("Grades: " + student.getAllGrades().toString());
        coursesLabel.setText("Courses: " + student.getAllGrades().keySet().toString());
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    /**
     * Sets dialog stage.
     *
     * @param dialogStage the dialog stage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Update grade table.
     *
     * @param selectedStudent the selected student
     */
    public void updateGradeTable(Student selectedStudent) {
        // update the label with the new grade
        gradesLabel.setText("Grades: " + selectedStudent.getAllGrades().toString());
    }
}
