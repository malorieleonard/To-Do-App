package org.todoapp.controller;

import org.todoapp.model.TaskManager;

public abstract class BaseController {
    protected TaskManager taskManage;

    public void setTaskManager(TaskManager taskManage) {
        this.taskManage = taskManage;
    }
}
