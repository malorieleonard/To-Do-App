package org.todoapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import org.todoapp.model.Task;
import org.todoapp.model.TaskManager;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class HomeController {

    private TaskManager taskManage;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private ListView<String> taskList;

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
    private void showTaskList() { loadView("TaskListView.fxml"); }

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

            contentPane.getChildren().setAll(content);

            AnchorPane.setTopAnchor(content, 30.0);
            AnchorPane.setRightAnchor(content, 30.0);
            AnchorPane.setBottomAnchor(content, 30.0);
            AnchorPane.setLeftAnchor(content, 30.0);

        } catch (IOException e) {
            System.err.println("Error: Could not read file.");
            e.printStackTrace();
        }
    }
}
