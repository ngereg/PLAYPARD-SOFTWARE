import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

/**
 * integration test top-down
 * 
 * @author yueheng han
 *
 */
public class FreemioIntegrationTest {

	/**
	 * test group 1 
	 * 1. login 
	 * 2. create multiple task 
	 * 3. sort task by name
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGroup1() throws IOException {
		// login
		Account testAcc = new Account("admin", "admin");
		boolean login = Account.validateAccount(testAcc);
		assertTrue(login);
		// create multiple task
		File tempTestFile = new File("testGroup1.txt");
		Task.createTask("atest", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		Task.createTask("ctest", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		Task.createTask("btest", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		// sort task by name
		ArrayList<Task> result = Task.sortByName(tempTestFile);
		String task1 = "0;atest;this is a test;5/3/2021;1;1";
		String task2 = "1;ctest;this is a test;5/3/2021;1;1";
		String task3 = "2;btest;this is a test;5/3/2021;1;1";
		ArrayList<String> correctAns = new ArrayList<String>();
		correctAns.add(task1);
		correctAns.add(task3);
		correctAns.add(task2);
		for (int i = 0; i < correctAns.size(); i++) {
			assertEquals(result.get(i).toString(), correctAns.get(i));
		}
		// delete test file
		tempTestFile.delete();
	}

	/**
	 * test group 2 
	 * 1. login 
	 * 2. create multiple task 
	 * 3. search task
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGroup2() throws IOException {
		// login
		Account testAcc = new Account("admin", "admin");
		boolean login = Account.validateAccount(testAcc);
		assertTrue(login);
		// create multiple task
		File tempTestFile = new File("testGroup2.txt");
		Task.createTask("Wash Car", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		Task.createTask("Do HW", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		Task.createTask("Review exam", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		// search task
		Scanner reader = new Scanner(tempTestFile);
		ArrayList<Task> result = Task.search(reader, "Do HW");
		String correctAns = "1;Do HW;this is a test;5/3/2021;1;1";
		assertEquals(result.get(0).toString(), correctAns);
		reader.close();
		// delete test file
		tempTestFile.delete();
	}

	/**
	 * test group 3 
	 * 1. login 
	 * 2. create multiple task 
	 * 3. show all the task 
	 * 4. update task 
	 * 5. show all the task again
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGroup3() throws IOException {
		// login
		Account testAcc = new Account("admin", "admin");
		boolean login = Account.validateAccount(testAcc);
		assertTrue(login);
		// create multiple task
		File tempTestFile = new File("testGroup3.txt");
		Task.createTask("Wash Car", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		Task.createTask("Do HW", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		Task.createTask("Review exam", "this is a test", "5/3/2021", 1, 1, tempTestFile);
		// show all the task 
		Scanner reader = new Scanner(tempTestFile);
		while (reader.hasNextLine()) {
			System.out.println(reader.nextLine());
		}
		reader.close();
		System.out.println("");
		// update task
		Task.updateProgress("Do HW", tempTestFile, -1);
		System.out.println("");
		// show all the task again
		Scanner reader2 = new Scanner(tempTestFile);
		while (reader2.hasNextLine()) {
			System.out.println(reader2.nextLine());
		}
		reader2.close();
		System.out.println("");
		// delete test file
		tempTestFile.delete();
	}
}
