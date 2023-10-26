package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import java.io.IOException;


/**
 * The type Student controller.
 */
public class StudentController {

    /**
     * Handle add student.
     *
     * @param name  the name
     * @param ID    the id
     * @param age   the age
     * @param grade the grade
     */
// Method to handle adding a student
    public void handleAddStudent(String name, String ID, int age, String grade) {
        StudentManagement.addStudent(name, ID, age, grade);
        return;
    }

    /**
     * Handle update student.
     *
     * @param ID       the id
     * @param newName  the new name
     * @param newAge   the new age
     * @param newGrade the new grade
     */
// Method to handle updating a student
    public void handleUpdateStudent(String ID, String newName, int newAge, String newGrade) {
        StudentManagement.updateStudent(ID, newName, newAge, newGrade);
        return;
    }

    /**
     * Handle view student student.
     *
     * @param ID the id
     * @return the student
     */
// Method to handle viewing a student
    public Student handleViewStudent(String ID) {
        return StudentManagement.getStudentDetails(ID);
    }

    /**
     * Handle add student button action.
     */
    public void handleAddStudentButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/AddStudent.fxml"));
            Parent dialogRoot = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Student");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene dialogScene = new Scene(dialogRoot);
            dialogStage.setScene(dialogScene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Add error handling here (e.g., show an error dialog)
        }
    }

}
