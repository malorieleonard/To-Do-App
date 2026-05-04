package org.todoapp.model;

/**
 * Interface for tasks that can be marked as complete.
 */
public interface Completable {

    /**
     * Marks a task as complete.
     */
    void markComplete();
}