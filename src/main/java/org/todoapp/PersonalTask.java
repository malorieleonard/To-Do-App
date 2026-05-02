package org.todoapp;

public class PersonalTask extends Task implements Completable {
    private String category;

    /**
     * Constructs a PersonalTask with the specified attributes.
     *
     * @param ID          the unique identifier for this task
     * @param name        the name of the task
     * @param rank        the rank of the task from 1-10
     * @param dueDate     the task's due date in the format "MM/DD/YR"
     * @param isCompleted a boolean indication of whether a task has been marked as complete
     * @param description a description of the task
     * @param category the category of the personal task
     */
    public PersonalTask(int ID, String name, int rank, String dueDate, boolean isCompleted, String description, String category) {
        super(ID, name, rank, dueDate, isCompleted, description);
        this.category = category;
    }

    /**
     * Sets the category of the PersonalTask
     *
     * @param category the category of the personal task
     */
    public void setCategory(String category){
        this.category = category;
    }

    /**
     *Gets the category of the PersonalTask
     *
     * @return the category of the personal task
     */
    public String getCategory(){
        return category;
    }

    /**
     * Marks the personal task as complete.
     */
    @Override
    public void markComplete() {
        setCompleted(true);
    }
}
