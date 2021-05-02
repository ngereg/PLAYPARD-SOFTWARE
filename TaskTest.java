import static org.junit.Assert.*;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class TaskTest {

	@Test
	public void testTask() {
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		// Task (int id, String name, String description, Date dueDate, int priority,
		// int progress)
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
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals("task", task.getname());
		task.setname("testSet");
		assertEquals("testSet", task.getname());
	}

	@Test
	public void testSetDescription() {
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals("This is a test Task", task.getDescription());
		task.setDescription("This is a set test");
		assertEquals("This is a set test", task.getDescription());
	}

	@Test
	public void testSetPriority() {
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(0, task.getPriority());
		task.setPriority(1);
		assertEquals(1, task.getPriority());
	}

	@Test
	public void testSetProgress() {
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(0, task.getProgress());
		task.setProgress(-1);
		assertEquals(-1, task.getProgress());
	}

	@Test
	public void testGetDueDate() {
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		assertEquals(dueDate, task.getDueDate());

		Date testDate = new Date(2022 - 1900, 4 - 1, 9);
		task.setDate(testDate);
		assertEquals(testDate, task.getDueDate());
	}

	@Test
	public void testMakeItTask() {
		String test = "0;task;This is a test Task;4/9/2021;0;0";
		String[] array = test.split(";");
		Task testTask = Task.makeItTask(array);
		assertEquals(test, testTask.toString());
	}

	@Test
	public void testMakeItDate() {
		String test = "4/9/2021";
		Date testDue = Task.makeItDate(test);
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		assertEquals(testDue, dueDate);
	}

	@Test
	public void testSearch() throws IOException {
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Date dueDate1 = new Date(2021 - 1900, 4 - 1, 10);
		Date dueDate2 = new Date(2021 - 1900, 4 - 1, 11);
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		Task task1 = new Task(1, "task1", "This is a test Task", dueDate1, 0, 0);
		Task task2 = new Task(2, "Testtask", "This is a test Task", dueDate2, 0, 0);
		ArrayList<Task> correctAns = new ArrayList<Task>();
		correctAns.add(task);
		correctAns.add(task1);
		correctAns.add(task2);
		String searchCond = "task";
		File tempTestFile = new File("TempTestFile.txt");
		FileWriter fw = new FileWriter(tempTestFile);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(task.toString());
		pw.println(task1.toString());
		pw.println(task2.toString());
		pw.close();
		fw.close();
		Scanner reader = new Scanner(tempTestFile);
		ArrayList<Task> result = Task.search(reader, searchCond);
		for (int i = 0; i < result.size(); i++) {
			assertEquals(result.get(i).toString(), correctAns.get(i).toString());
		}
		reader.close();
		tempTestFile.delete();
	}

	@Test
	public void testCreate() throws IOException {
		File tempTestFile = new File("TestFile.txt");
		String dueDate = "4/9/2021";
		Task.createTask("test0", "This is a test Task", dueDate, 0, 0, tempTestFile);
		Task.createTask("test1", "This is a test Task", dueDate, 0, 0, tempTestFile);
		Task.createTask("test2", "This is a test Task", dueDate, 0, 0, tempTestFile);
		String test1 = "0;test0;This is a test Task;4/9/2021;0;0";
		String test2 = "1;test1;This is a test Task;4/9/2021;0;0";
		String test3 = "2;test2;This is a test Task;4/9/2021;0;0";
		ArrayList<String> correctAns = new ArrayList<String>();
		correctAns.add(test1);
		correctAns.add(test2);
		correctAns.add(test3);
		Scanner reader = new Scanner(tempTestFile);
		int i = 0;
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(";");
			Task temp1 = Task.makeItTask(array);
			assertEquals(temp1.toString(), correctAns.get(i));
			i++;
		}
		reader.close();
		tempTestFile.delete();
	}
	
	@Test
	public void testSortTasks() throws IOException {
		File tempTestFile = new File("TestFile2.txt");
		String dueDate1 = "4/20/2021";
		String dueDate2 = "4/23/2021";
		String dueDate3 = "5/20/2021";
		Task.createTask("btest", "This is a test Task", dueDate2, 1, 0, tempTestFile);
		Task.createTask("atest", "This is a test Task", dueDate1, 0, -1, tempTestFile);
		Task.createTask("ctest", "This is a test Task", dueDate3, 0, 1, tempTestFile);
		String test1 = "0;btest;This is a test Task;4/23/2021;1;0";
		String test2 = "1;atest;This is a test Task;4/20/2021;0;-1";
		String test3 = "2;ctest;This is a test Task;5/20/2021;0;1";
		//test sort by name;
		ArrayList<String> correctAns1 = new ArrayList<String>();
		correctAns1.add(test2);
		correctAns1.add(test1);
		correctAns1.add(test3);
		ArrayList<Task> res1 = Task.sortByName(tempTestFile);
		for (int i = 0; i < correctAns1.size(); i++) {
			assertEquals(res1.get(i).toString(), correctAns1.get(i));
		}
		
		//test sort by progress;
		ArrayList<String> correctAns2 = new ArrayList<String>();
		correctAns2.add(test2);
		correctAns2.add(test1);
		correctAns2.add(test3);
		ArrayList<Task> res2 = Task.sortByProgress(tempTestFile);
		for (int i = 0; i < correctAns2.size(); i++) {
			assertEquals(res2.get(i).toString(), correctAns2.get(i));
		}
		
		//test sort by priority;
		ArrayList<String> correctAns3 = new ArrayList<String>();
		correctAns3.add(test1);
		correctAns3.add(test2);
		correctAns3.add(test3);
		ArrayList<Task> res3 = Task.sortByPriority(tempTestFile);
		for (int i = 0; i < correctAns3.size(); i++) {
			assertEquals(res3.get(i).toString(), correctAns3.get(i));
		}
		
		tempTestFile.delete();
	}
	
	public void testTaskGroup() throws IOException {
		ArrayList<Task> taskGroup = new ArrayList<Task>();
		File tempTestFile = new File("TestFile2.txt");
		String dueDate1 = "4/20/2021";
		String dueDate2 = "4/23/2021";
		String dueDate3 = "5/20/2021";
		Task.createTask("btest", "This is a test Task", dueDate2, 1, 0, tempTestFile);
		Task.createTask("atest", "This is a test Task", dueDate1, 0, -1, tempTestFile);
		Task.createTask("ctest", "This is a test Task", dueDate3, 0, 1, tempTestFile);
	}
	
	@Test
	public void testreminder() {
		Date dueDate = new Date(2021-1900, 4-1, 9);
		String email= "email@email.com";
		Task task = new Task(0, "task", "This is a test Task", dueDate, 0, 0);
		// assertTrue(Task.setreminder(email,task));
	}
	
	@Test
	public void testUpdate() throws IOException {
		File tempTestFile = new File("TestFile3.txt");
		String dueDate1 = "4/20/2021";
		String dueDate2 = "4/23/2021";
		String dueDate3 = "5/20/2021";
		Task.createTask("test1", "This is a test Task", dueDate1, 0, 0, tempTestFile);
		Task.createTask("test2", "This is a test Task", dueDate2, 0, 0, tempTestFile);
		Task.createTask("test3", "This is a test Task", dueDate3, 0, 0, tempTestFile);
		String test1 = "0;test1;This is a test Task;4/20/2021;0;1";
		String test2 = "1;test2;This is a test Task;4/23/2021;0;0";
		String test3 = "2;test3;This is a test Task;5/20/2021;0;0";
		ArrayList<String> correctAns = new ArrayList<String>();
		correctAns.add(test1);
		correctAns.add(test2);
		correctAns.add(test3);
		Task.updateProgress("test1", tempTestFile, 1);
		Scanner reader = new Scanner(tempTestFile);
		int i = 0;
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(";");
			Task temp1 = Task.makeItTask(array);
			assertEquals(temp1.toString(), correctAns.get(i));
			i++;
		}
		reader.close();
		tempTestFile.delete();
	}
}
