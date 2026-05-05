package org.todoapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.todoapp.model.TaskManager;

import java.io.IOException;

public class HomeController {
    @FXML
    private BorderPane rootPane;

    @FXML
    private Label statusLabel;

    private TaskManager taskManage;

    @FXML
    public void initialize() {
        setStatus("Ready");
    }

    public void setTaskManager(TaskManager taskManage) {
        this.taskManage = taskManage;
        loadView("HomeView.fxml");
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

    public void setStatus(String message) {
        statusLabel.setText(message);
    }

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
            setStatus("Loaded: " + fxmlFile.replace("View.fxml", ""));
        } catch (IOException e) {
            setStatus("Unable to load view: " + fxmlFile);
            e.printStackTrace();
        }
    }
}
