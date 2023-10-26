package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Course;
import com.example.studentmanagementsystem.model.CourseManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * The type Course view controller.
 */
public class CourseViewController {
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableColumn<Course, String> courseNameColumn;
    @FXML
    private TableColumn<Course, String> courseIDColumn;

    private ObservableList<Course> courseData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialize the course table
        courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        courseIDColumn.setCellValueFactory(cellData -> cellData.getValue().courseIDProperty());

        // Load initial course data
        courseData.addAll(CourseManagement.getCourses());
        courseTable.setItems(courseData);
    }
}
