package com.example.studentmanagementsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Main app.
 */
public class MainApp extends Application implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    @Override
    public void handle(ActionEvent actionEvent) {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studentmanagementsystem/MainApp.fxml"));
            Parent root = loader.load();

            // Set the scene on the primary stage
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Student Management System");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
