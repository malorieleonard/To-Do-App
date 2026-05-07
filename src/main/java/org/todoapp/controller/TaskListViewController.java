package org.todoapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.todoapp.model.TaskManager;

public class TaskListViewController extends BaseController {

    @FXML
    private ListView<String> taskList;

    @Override
    public void setTaskManager(TaskManager taskManager) {
        super.setTaskManager(taskManager);
        refreshList();
    }

    private void refreshList() {
        taskList.getItems().clear();

        if (taskManage.getTasks().isEmpty()) {
            taskList.getItems().add("Tasks are all finished. Good job!");
        } else {
            taskManage.getTasks().forEach(t -> taskList.getItems().add(t.toString()));
        }
    }
}
