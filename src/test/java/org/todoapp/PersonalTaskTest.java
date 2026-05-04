package org.todoapp;

import junit.framework.TestCase;
import org.todoapp.model.PersonalTask;

public class PersonalTaskTest extends TestCase {
    public void testPersonalTaskConstructorAndGetters() {
        PersonalTask task = new PersonalTask(
                105,
                "Do the dishes",
                7,
                "05/15/26",
                false,
                "Clean the dishes and put them on the dry rack",
                "Kitchen Chores"
        );
        assertEquals(105, task.getID());
        assertEquals("Do the dishes", task.getName());
        assertEquals(7, task.getRank());
        assertEquals("05/15/26", task.getDueDate());
        assertFalse(task.isCompleted());
        assertEquals("Clean the dishes and put them on the dry rack", task.getDescription());
        assertEquals("Kitchen Chores", task.getCategory());
    }

    public void testSetters() {
        PersonalTask task = new PersonalTask(
                115,
                "cook dinner",
                9,
                "05/10/26",
                false,
                "Make dinner for family",
                "Meal Prep"
        );


        task.setDueDate("05/11/26");

        assertEquals("05/11/26", task.getDueDate());
    }

    public void testMarkComplete() {
        PersonalTask task = new PersonalTask(
                101,
                "Walk the dog",
                6,
                "05/20/26",
                false,
                "Walk the dog by noon",
                "Animal chores"

        );

        task.markComplete();

        assertTrue(task.isCompleted());
    }
}

