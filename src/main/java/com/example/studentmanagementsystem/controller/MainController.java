package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;
    @FXML
    private TableColumn<Student, String> gradeColumn;

    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialize the student table with the four columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());

        // Load initial data
        studentData.addAll(StudentManagement.getStudents());
        studentTable.setItems(studentData);
    }

    @FXML
    private void handleAddStudentButtonAction() {
        // Code to handle adding a new student
    }

    @FXML
    private void handleUpdateStudentButtonAction() {
        // Code to handle updating a student
    }

    @FXML
    private void handleViewStudentDetailsButtonAction() {
        // Code to handle viewing student details
    }
}
