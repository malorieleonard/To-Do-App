package org.todoapp;

import junit.framework.TestCase;

public class BusinessTaskTest extends TestCase {

    public void testBusinessTaskConstructorAndGetters() {
        BusinessTask task = new BusinessTask(
                109,
                "Finish excel sheet",
                10,
                "05/1/26",
                false,
                "Finish excel sheet of business expenses",
                "Google"
        );

        assertEquals(109, task.getID());
        assertEquals("Finish excel sheet", task.getName());
        assertEquals(10, task.getRank());
        assertEquals("05/1/26", task.getDueDate());
        assertFalse(task.isCompleted());
        assertEquals("Finish excel sheet of business expenses", task.getDescription());
        assertEquals("Google", task.getCompany());
    }

    public void testSetters() {
        BusinessTask task = new BusinessTask(
                110,
                "Meeting 12:30",
                6,
                "05/07/26",
                false,
                "Initial description",
                "Google"
        );

        task.setCompany("Apple");

        assertEquals("Apple", task.getCompany());
    }

    public void testMarkComplete() {
        BusinessTask task = new BusinessTask(
                111,
                "Finish financing project",
                8,
                "05/17/26",
                false,
                "Complete financing project for the month",
                "Apple"
        );

        task.markComplete();

        assertTrue(task.isCompleted());
    }
}