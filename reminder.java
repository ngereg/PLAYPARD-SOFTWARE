import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class reminder extends JFrame implements ActionListener {
	private JTextField uid, pwd;
	private JPanel bottonpanel, mainpanel, panel1, panel2, panelCurrDate;
	private JTextArea group1Text;
	private JTextArea showTasks;
	private JButton searchbutton, searchbutton2, viewTasksButton;

	private ArrayList<Task> tasks;
	ArrayList<reminder> textFile;

	Account mainaccount;
	String username, taskName;
	Date dueDate;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	// constructors
	public reminder(String tn, Date dued) {
		taskName = tn;
		dueDate = dued;
	}

	String getDescription() {
		return taskName;
	}

	String getDueDate() {
		return formatter.format(dueDate);
	}

	// prints only the title and the date of the tasks of all the tasks created in
	// the user text file
	public String toString() {
		return "\n Task Name: " + taskName + "\n DueDate: " + formatter.format(dueDate);
	}

	public reminder(Account account) {
		mainpanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		mainaccount = account;

		username = account.getUserName();

		// add clock that shows todays date

		// JLabel info = new JLabel("All of your tasks and due date");
		panel1.setBorder(new TitledBorder("Only Tasks name and due date"));
		showTasks = new JTextArea(10, 30);
		viewTasksButton = new JButton("Simple View"); // when click, displays only the tasks and its due date
		panel1.add(showTasks);
		mainpanel.add(panel1);
		panel1.add(viewTasksButton);

		panel2.setBorder(new TitledBorder(""));
		searchbutton = new JButton("Click to view OVER DUE TASKS"); // when clicked, displays tasks that are over the
																	// current date
		panel2.add(searchbutton);
		mainpanel.add(panel2);

		searchbutton2 = new JButton("Click to view PAST TASKS"); // when clicked, displays tasks that are under the
																	// current date
		panel2.add(searchbutton2);
		mainpanel.add(panel2);

//		CreateGroup1 = new JButton("Create Group 1");
//		CreateGroup1.addActionListener(this);
//		

		File file = new File(username + ".txt");
		ArrayList<Task> tasks = null;
		try {
			tasks = Task.loadFromFile(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		add(mainpanel);

	}

	JTextField dateField;

	public void actionPerformed(ActionEvent arg0) {
		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		panelCurrDate = new JPanel();
		int month = calendar.getTime().getMonth();
		int day = calendar.getTime().getDate();
		int year = calendar.getTime().getYear();

		

		if (arg0.getActionCommand().equals("Click to view OVER DUE TASKS")) {
			// show only the tasks that are over the current date
			
		}
	}

//read the txt file but only print the date and the task name
	public void readFile() throws FileNotFoundException {
		Scanner read = new Scanner (new File(username + ".txt"));
		   while(read.hasNext()) {
			   String all = read.nextLine();
		       String taskName = read.next();
		       String desc = read.next();
		       String date = read.next();
		       String priority = read.next();
		       String progress = read.next();    
		       
		       String each[] = all.split(";");
		       textFile.add(new reminder(each[0], formatter.parse(each[1]));
//		       mainpanel.add(date);
//		       mainpanel.add(taskName);
		   }
		   read.close();
		
	}

	// ==================
	class DateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Calendar now = Calendar.getInstance();
			int month = now.get(Calendar.MONTH);
			int day = now.get(Calendar.DAY_OF_MONTH);
			int year = now.get(Calendar.YEAR);
			dateField.setText("" + (month + 1) + "/" + day + "/" + year);

		}
	}

}