package org.example;

import junit.framework.TestCase;

public class TaskManagerTest extends TestCase {

    public void testAddTask() {
        TaskManager manager = new TaskManager();
        Task task = new EducationalTask(1, "Quiz Study", 7, "04/28/26", false,
                "Study for quiz", "CSC 331", "Professor Smith");

        manager.addTask(task);

        assertEquals(1, manager.getTasks().size());
        assertEquals(task, manager.getTasks().get(0));
    }

    public void testFindTaskById() {
        TaskManager manager = new TaskManager();
        Task task = new EducationalTask(2, "Essay", 9, "04/29/26", false,
                "Write rough draft", "ENG 201", "Dr. Green");

        manager.addTask(task);

        assertEquals(task, manager.findTaskById(2));
        assertNull(manager.findTaskById(99));
    }

    public void testRemoveTaskById() {
        TaskManager manager = new TaskManager();
        Task task = new EducationalTask(3, "Lab Work", 5, "05/02/26", false,
                "Complete lab activity", "BIO 101", "Dr. White");

        manager.addTask(task);

        assertTrue(manager.removeTaskById(3));
        assertEquals(0, manager.getTasks().size());
        assertFalse(manager.removeTaskById(3));
    }
}