module com.example.studentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.studentmanagementsystem to javafx.graphics;
    exports com.example.studentmanagementsystem.controller to javafx.fxml;
    opens com.example.studentmanagementsystem to javafx.fxml;
    opens com.example.studentmanagementsystem.controller to javafx.fxml;
}
