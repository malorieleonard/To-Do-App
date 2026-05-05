module org.todoapp {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.todoapp;
    exports org.todoapp.controller;
    exports org.todoapp.model;

    opens org.todoapp to javafx.fxml;
    opens org.todoapp.controller to javafx.fxml;
}