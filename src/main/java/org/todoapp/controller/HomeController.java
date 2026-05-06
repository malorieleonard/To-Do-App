package org.todoapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.todoapp.model.TaskManager;

import java.io.IOException;

public class HomeController {

    private TaskManager taskManage;

    @FXML
    private BorderPane rootPane;

    public void setTaskManager(TaskManager taskManage) {
        this.taskManage = taskManage;
    }

    @FXML
    private void showPersonalTask() {
        loadView("PersonalTaskView.fxml");
    }

    @FXML
    private void showBusinessTask() {
        loadView("BusinessTaskView.fxml");
    }

    @FXML
    private void showEducationalTask() {
        loadView("EducationalTaskView.fxml");
    }

    @FXML
    private void showHome() { loadView("HomeView.fxml");}

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxmlFile));
            Node content = loader.load();
            Object controller = loader.getController();

            if (controller instanceof BaseController baseController) {
                baseController.setTaskManager(taskManage);
            }
            if (controller instanceof StatusAware statusAware) {
                statusAware.setHomeController(this);
            }

            rootPane.setCenter(content);

        } catch (IOException e) {
            System.err.println("Error: Could not read file.");
            e.printStackTrace();
        }
    }
}
