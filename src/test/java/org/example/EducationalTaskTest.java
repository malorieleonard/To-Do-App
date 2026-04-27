package org.example;

import junit.framework.TestCase;

public class EducationalTaskTest extends TestCase {

    public void testEducationalTaskConstructorAndGetters() {
        EducationalTask task = new EducationalTask(
                101,
                "Study Chapter 5",
                8,
                "04/30/26",
                false,
                "Read and review chapter 5 notes",
                "CSC 331",
                "Professor Smith"
        );

        assertEquals(101, task.getID());
        assertEquals("Study Chapter 5", task.getName());
        assertEquals(8, task.getRank());
        assertEquals("04/30/26", task.getDueDate());
        assertFalse(task.isCompleted());
        assertEquals("Read and review chapter 5 notes", task.getDescription());
        assertEquals("CSC 331", task.getClassName());
        assertEquals("Professor Smith", task.getTeacher());
    }

    public void testSetters() {
        EducationalTask task = new EducationalTask(
                102,
                "Homework",
                6,
                "05/01/26",
                false,
                "Initial description",
                "MAT 161",
                "Dr. Lee"
        );

        task.setClassName("CSC 340");
        task.setTeacher("Dr. Brown");

        assertEquals("CSC 340", task.getClassName());
        assertEquals("Dr. Brown", task.getTeacher());
    }

    public void testMarkComplete() {
        EducationalTask task = new EducationalTask(
                103,
                "Finish project",
                10,
                "05/05/26",
                false,
                "Complete final project",
                "CSC 331",
                "Professor Smith"
        );

        task.markComplete();

        assertTrue(task.isCompleted());
    }
}