package org.todoapp.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 * Manages a collection of tasks.
 * Provides methods to add, remove, search, and save tasks.
 */
public class TaskManager {
    private ArrayList<Task> tasks;
    private static final Path DATA_DIR    = Paths.get("data");
    private static final Path TASK_FILE    = Paths.get("data", "tasks.txt");

    /**
     * Constructs a TaskManager and initializes the task list.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
        try {
            if (!Files.exists(DATA_DIR)) {
                Files.createDirectories(DATA_DIR);
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read file.");
        }
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
    public void saveTasks(String fileName) throws IOException {
        try(Formatter fmt = new Formatter(TASK_FILE.toFile())) {
            for (Task t : tasks) {
                fmt.format("%d,%s,%d,%s,%s", t.getID(), t.getName(), t.getRank(), t.getDueDate(), t.getDescription());
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read file.");
        }
    }

    public void loadTasks() throws IOException {
        tasks.clear();
        try {
            if (!Files.exists(TASK_FILE)) {
                return;
            }
            try (Scanner load = new Scanner(TASK_FILE.toFile())) {
                while (load.hasNextLine()) {
                    String line = load.nextLine();
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int rank = Integer.parseInt(parts[2]);
                    String dueDate = parts[3];
                    String description = parts[4];
                    Task task = new Task(id, name, rank, dueDate, false, description);
                    if (task != null) {
                        tasks.add(task);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read file.");
        }
    }
}