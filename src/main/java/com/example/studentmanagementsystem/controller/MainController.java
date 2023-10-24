package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.model.StudentManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private Stage primaryStage;

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
    private void handleAddStudentButtonAction(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/AddStudent.fxml"));

            Parent root = loader.load();

            AddStudentController controller = loader.getController();
            controller.setMainController(this);


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Student");
            dialogStage.initModality(Modality.WINDOW_MODAL);  // This line makes the dialog modal
            dialogStage.initOwner(primaryStage);
            dialogStage.setScene(new Scene(root));

// Set the dialog stage in the controller
            controller.setDialogStage(dialogStage);

            // Show the dialog
            dialogStage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void addStudent(Student student) {
        studentData.add(student);
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
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
