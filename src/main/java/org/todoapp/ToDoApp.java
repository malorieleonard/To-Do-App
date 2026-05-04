package org.todoapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.todoapp.controller.HomeController;
import org.todoapp.model.TaskManager;

public class ToDoApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomeView.fxml"));
        Scene scene = new Scene(loader.load(), 1050, 680);

        TaskManager taskmanager = new TaskManager();
        HomeController homeController = loader.getController();
        homeController.setTaskManager(taskmanager);

        stage.setTitle("To Do App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
