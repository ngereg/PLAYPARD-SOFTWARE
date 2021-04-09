import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TaskTest {

	@Test
	public void testTask() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		// Task (int id, String name, String description, Date dueDate, int priority, int progress)
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(0, task.getID());
		assertEquals("task", task.getname());
		assertEquals("This is a test Task", task.getDescription());
		assertEquals(dueDate, task.getDueDate());
		assertEquals(0, task.getPriority());
		assertEquals(0, task.getProgress());
	}
	
	@Test
	public void testSetname() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals("task", task.getname());
		task.setname("testSet");
		assertEquals("testSet", task.getname());
	}

	@Test
	public void testSetDescription() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals("This is a test Task", task.getDescription());
		task.setDescription("This is a set test");
		assertEquals("This is a set test", task.getDescription());
	}

	@Test
	public void testSetPriority() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(0, task.getPriority());
		task.setPriority(1);
		assertEquals(1, task.getPriority());
	}

	@Test
	public void testSetProgress() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(0, task.getProgress());
		task.setProgress(-1);
		assertEquals(-1, task.getProgress());
	}

	@Test
	public void testGetDueDate() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(dueDate, task.getDueDate());
		
		Date testDate = new Date(2022-1900, 4-1, 9);
		task.setDate(testDate);
		assertEquals(testDate, task.getDueDate());
	}
	
	@Test
	public void testToString() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		String test = "0;task;This is a test Task;4/9/2021;0;0";
		assertEquals(test, task.toString());
	}
}
