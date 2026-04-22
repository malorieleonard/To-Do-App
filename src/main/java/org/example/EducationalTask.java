package org.example;

/**
 * Represents an educational task in the to-do list.
 * Inherits common task details from Task and adds class-specific information.
 */
public class EducationalTask extends Task implements Completable {
    private String className;
    private String teacher;

    /**
     * Constructs an EducationalTask with the specified attributes.
     *
     * @param ID          the unique identifier for this task
     * @param name        the name of the task
     * @param rank        the rank of the task from 1-10
     * @param dueDate     the due date of the task
     * @param isCompleted whether the task is completed
     * @param description the task description
     * @param className   the class associated with the task
     * @param teacher     the teacher associated with the task
     */
    public EducationalTask(int ID, String name, int rank, String dueDate,
                           boolean isCompleted, String description,
                           String className, String teacher) {
        super(ID, name, rank, dueDate, isCompleted, description);
        this.className = className;
        this.teacher = teacher;
    }

    /**
     * Sets the class name for this educational task.
     *
     * @param className the class name
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the class name for this educational task.
     *
     * @return the class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the teacher for this educational task.
     *
     * @param teacher the teacher name
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * Gets the teacher for this educational task.
     *
     * @return the teacher name
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Marks this educational task as complete.
     */
    @Override
    public void markComplete() {
        setCompleted(true);
    }
}