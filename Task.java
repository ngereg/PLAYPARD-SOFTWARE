import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
/**
 * Task object and functions
 * @author Yueheng Han
 *
 */
public class Task {
	private int id;
	private String name;
	private String description;
	private Date dueDate; // int year(current-1900); int month(current-1); int date
	private int priority; // 0 is normal, 1 is emergency
	private int progress; // -1 is finish, 0 is doing, 1 is to do
	
	/**
	 * Task constructor
	 * @param id Task id
	 * @param name Task name
	 * @param description Task description
	 * @param dueDate Task due date
	 * @param priority Task priority, 0 is normal, 1 is emergency
	 * @param progress Task progress, -1 is finish, 0 is doing, 1 is to do
	 */
	public Task(int id, String name, String description, Date dueDate, int priority, int progress) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.progress = progress;
	}

	// Getter Methods
	public int getID() {
		return id;
	}

	public String getname() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public int getPriority() {
		return priority;
	}

	public int getProgress() {
		return progress;
	}

	// Setter Methods
	public void setname(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	/**
	 * parse the object to string
	 */
	public String toString() {
		int dueDateYear = dueDate.getYear() + 1900;
		int dueDateMonth = dueDate.getMonth() + 1;
		String date = dueDateMonth + "/" + dueDate.getDate() + "/" + dueDateYear;
		return id + ";" + name + ";" + description + ";" + date + ";" + priority + ";" + progress;
	}
	
	/**
	 * Create task by user input
	 * @param name Task name given by user
	 * @param description Task description given by user
	 * @param dueDate Task due date given by user
	 * @param priority Task priority given by user, 0 is normal, 1 is emergency
	 * @param progress Task progress given by user, -1 is finish, 0 is doing, 1 is to do
	 * @param file The file of the specific that store all task
	 * @throws IOException
	 */
	public static void createTask(String name, String description, String dueDate, int priority, int progress,
			File file) throws IOException {
		boolean empty = file.length() == 0;
		int ID = 0;
		if (!empty) {
			FileReader fr = new FileReader(file);
			BufferedReader input = new BufferedReader(fr);
			String last = null, line;
			while ((line = input.readLine()) != null) {
				last = line;
			}
			input.close();
			ID = Integer.parseInt(last.substring(0, last.indexOf(";"))) + 1;
		}
		Date due = makeItDate(dueDate);
		Task newTask = new Task(ID, name, description, due, priority, progress);
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(newTask.toString());
		pw.close();
		//System.out.println(newTask.toString());
	}
	
	/**
	 * Search task base the task name given by user input
	 * @param reader scanner of the file of the specific that store all task
	 * @param searchCond search condition given by user input
	 * @return An array list has all the task match the user input
	 */
	public static ArrayList<Task> search(Scanner reader, String searchCond) {
		// TODO Auto-generated method stub
		ArrayList<Task> result = new ArrayList<Task>();
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(";");
			String temptaskname = array[1];
			if (temptaskname.contains(searchCond)) {
				result.add(makeItTask(array));
			}
		}
		return result;
	}
	
	/**
	 * Parse the date in string to date object
	 * @param dateInString date in string
	 * @return date object
	 */
	public static Date makeItDate(String dateInString) {
		String[] array = dateInString.split("/");
		int year = Integer.parseInt(array[2]);
		int mouth = Integer.parseInt(array[0]);
		int date = Integer.parseInt(array[1]);
		return new Date(year - 1900, mouth - 1, date);

	}
	
	/**
	 * Parse the task in string to task object
	 * @param array an array contain all task parameter in string
	 * @return task object
	 */
	public static Task makeItTask(String[] array) {
		int tempId = Integer.parseInt(array[0]);
		int tempPriority = Integer.parseInt(array[4]);
		int tempProgress = Integer.parseInt(array[5]);
		Date tempDue = makeItDate(array[3]);
		return new Task(tempId, array[1], array[2], tempDue, tempPriority, tempProgress);
	}
	
	/**
	 * load all tasks in file to an array list
	 * @param file The file of the specific that store all task
	 * @return A task array list contain all task
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Task> loadFromFile(File file) throws FileNotFoundException {
		ArrayList<Task> result = new ArrayList<Task>();
		Scanner in = new Scanner(file);
		while(in.hasNextLine()) {
			String temp = in.nextLine();
			String[] array = temp.split(";");
			result.add(makeItTask(array));
		}
		in.close();
		return result;
	}
	
	/**
	 * the comparator for sort by name
	 */
	public static Comparator<Task> taskNameComparator = new Comparator<Task>() {

		public int compare(Task t1, Task t2) {
			String taskName1 = t1.getname().toLowerCase();
			String taskName2 = t2.getname().toLowerCase();
			
			return taskName1.compareTo(taskName2);
		}
	};
	
	/**
	 * the comparator for sort by progress
	 */
	public static Comparator<Task> taskProgressComparator = new Comparator<Task>() {

		public int compare(Task t1, Task t2) {
			int taskProgress1 = t1.getProgress();
			int taskProgress2 = t2.getProgress();
			
			return taskProgress1-taskProgress2;
		}
	};
	
	/**
	 * the comparator for sort by priority
	 */
	public static Comparator<Task> taskPriorityComparator = new Comparator<Task>() {

		public int compare(Task t1, Task t2) {
			int taskPriority1 = t1.getPriority();
			int taskPriority2 = t2.getPriority();
			
			return taskPriority2-taskPriority1;
		}
	};
	
	/**
	 * Sort all the task by task name
	 * @param file The file of the specific that store all task
	 * @return An array list of all task sorted by name
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Task> sortByName(File file) throws FileNotFoundException{
		ArrayList<Task> result = Task.loadFromFile(file);
		System.out.println("This is sort by name");
		System.out.println("before sort");
		for(Task str: result){
			System.out.println(str);
	    }
		Collections.sort(result, Task.taskNameComparator);
		System.out.println("after sort");
		for(Task str: result){
			System.out.println(str);
	    }
		System.out.println("");
		return result;
	}
	
	/**
	 * Sort all the task by task progress
	 * @param file The file of the specific that store all task
	 * @return An array list of all task sorted by name
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Task> sortByProgress(File file) throws FileNotFoundException {
		ArrayList<Task> result = Task.loadFromFile(file);
		System.out.println("This is sort by progress");
		System.out.println("before sort");
		for(Task str: result){
			System.out.println(str);
	    }
		Collections.sort(result, Task.taskProgressComparator);
		System.out.println("after sort");
		for(Task str: result){
			System.out.println(str);
	    }
		System.out.println("");
		return result;
	}
	
	/**
	 * Sort all the task by task priority
	 * @param file The file of the specific that store all task
	 * @return An array list of all task sorted by name
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Task> sortByPriority(File file) throws FileNotFoundException {
		ArrayList<Task> result = Task.loadFromFile(file);
		System.out.println("This is sort by priority");
		System.out.println("before sort");
		for(Task str: result){
			System.out.println(str);
	    }
		Collections.sort(result, Task.taskPriorityComparator);
		System.out.println("after sort");
		for(Task str: result){
			System.out.println(str);
	    }
		System.out.println("");
		return result;
	}
	
	/**
	 * update task progress given by user input
	 * @param oldTaskName the task name which need to be update given by user input
	 * @param file The file of the specific that store all task
	 * @param newProg The new task progress
	 * @throws IOException
	 */
	public static void updateProgress(String oldTaskName, File file, int newProg) throws IOException { 
		Scanner scan = new Scanner(file);
		ArrayList<Task> result = Task.search(scan, oldTaskName);
		Task oldTask = result.get(0);
		String oldString = oldTask .toString();
		System.out.println(oldString);
		oldTask.setProgress(newProg);
		String newString = oldTask.toString();
		System.out.println(newString);
		String oldContent = "";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while (line != null) {
			oldContent = oldContent + line + System.lineSeparator();
			line = reader.readLine();
		}
		String newContent = oldContent.replaceAll(oldString, newString);
		FileWriter writer = new FileWriter(file);
		writer.write(newContent);
		scan.close();
		reader.close();
		writer.close();
	}
}