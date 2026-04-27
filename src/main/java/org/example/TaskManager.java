package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of tasks.
 * Provides methods to add, remove, search, and save tasks.
 */
public class TaskManager {
    private ArrayList<Task> tasks;

    /**
     * Constructs a TaskManager and initializes the task list.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     *
     * @param task the task to add
     */
    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    /**
     * Removes a task by ID.
     *
     * @param id the task ID to remove
     * @return true if removed, false if not found
     */
    public boolean removeTaskById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getID() == id) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a task by ID.
     *
     * @param id the task ID
     * @return the matching task, or null if not found
     */
    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getID() == id) {
                return task;
            }
        }
        return null;
    }

    /**
     * Returns all tasks.
     *
     * @return a list of tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Saves all tasks to a file.
     *
     * @param fileName the file to save to
     * @throws IOException if the file cannot be written
     */
    public void saveTasksToFile(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));

        for (Task task : tasks) {
            writer.println(task.toString());
        }

        writer.close();
    }
}