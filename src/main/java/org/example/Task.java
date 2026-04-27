package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class representing a task within a to-do list.
 * Each task has an ID, name, rank, due date, indication of completion, description.
 */
public class Task {
    private int ID;
    private String name;
    private int rank;
    private String dueDate;
    private boolean isCompleted;
    private String description;

    /**
     * Constructs a new Task with the specified attributes.
     *
     * @param ID          the unique identifier for this task
     * @param name        the name of the task
     * @param rank        the rank of the task from 1-10
     * @param dueDate     the task's due date in the format "MO/DD/YR"
     * @param isCompleted a boolean indication of whether a task has been marked as complete
     * @param description a description of the task
     */
    public Task(int ID, String name, int rank, String dueDate, boolean isCompleted, String description) {
        this.ID = ID;
        this.name = name;
        this.rank = rank;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.description = description;
    }

    /**
     * Returns the unique identifier for this task
     * @return the task's ID
     */
    public int getID() { return ID; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the task
     * @return the task's name
     */
    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the rank of the task
     * @return the task's rank
     */
    public int getRank() { return rank; }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Returns the due date of the task
     * @return the task's due date
     */
    public String getDueDate() { return dueDate; }

    /**
     * Allows modification of the task due date
     * @param dueDate the tasks due date in the format "MO/DD/YR"
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Used to determine if a task is complete
     * @return a boolean indication of whether a task has been marked as complete
     */
    public boolean isCompleted() { return isCompleted; }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return ID + "," + name + "," + rank + "," + dueDate + "," + isCompleted + "," + description;
    }
}
