package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.CourseManagement;
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
import com.example.studentmanagementsystem.model.Course;
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
    private Stage primaryStage;
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableColumn<Course, String> courseNameColumn;
    @FXML
    private TableColumn<Course, String> courseIDColumn;

    private ObservableList<Course> courseData = FXCollections.observableArrayList();


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
    public void updateStudent(Student student) {
        // Assuming studentData is your ObservableList
        int index = studentData.indexOf(student);
        if (index != -1) {
            studentData.set(index, student); // Update student in the list
            studentTable.refresh();         // Refresh the table
        }
    }


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    @FXML
    private void handleAddCourseAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/AddCourse.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Course");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleEnrollStudentAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/EnrollStudent.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Enroll Student"); // Fixed the missing quotation mark
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAssignGradeAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/AssignGrade.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Assign Grade"); // Fixed the title
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUpdateStudentButtonAction() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/UpdateStudent.fxml"));
                Parent root = loader.load();

                UpdateStudentController controller = loader.getController();
                controller.setMainController(this);
                controller.setSelectedStudent(selectedStudent);

                Stage stage = new Stage();
                stage.setTitle("Update Student");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // No student selected. Show an alert or message.
        }
    }


    @FXML
    private void handleViewStudentDetailsButtonAction() {
        // Code to handle viewing student details
    }

    public void handleViewCoursesAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/ViewCourses.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("View Courses");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
