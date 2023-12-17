module com.example.db_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.db_app to javafx.fxml;
    exports com.example.db_app;
}