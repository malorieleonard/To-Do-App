package org.todoapp.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.todoapp.model.TaskManager;
import java.io.IOException;

public abstract class BaseController {
    protected TaskManager taskManage;

    public void setTaskManager(TaskManager taskManage) {
        this.taskManage = taskManage;
    }
}
