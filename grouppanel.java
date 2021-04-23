import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class grouppanel extends JFrame implements ActionListener {
	private JTextField uid, pwd;
	private JPanel bottonpanel, mainpanel, sortpanel, sortbottonpanel, taskpanel;
	private JTextArea group1Text, group2Text, group3Text;
	private JButton CreateGroup1, CreateGroup2, CreateGroup3;
	private String groupName1, groupName2, groupName3;
	private ArrayList<String> group1Tasks;
	private ArrayList<String> group2Tasks;
	private ArrayList<String> group3Tasks;
	private ArrayList<Task> tasks;
	private ArrayList<Task> tasksToAdd;
	Account mainaccount;
	String username;

	public grouppanel(Account account) {
		mainpanel=new JPanel();
		mainaccount=account;
		bottonpanel=new JPanel();
		sortpanel = new JPanel();
		sortbottonpanel = new JPanel();
		username=account.getUserName();
		group1Text = new JTextArea(10, 10);
		sortpanel.add(group1Text);
		group2Text = new JTextArea(10, 10);
		sortpanel.add(group2Text);
		group3Text = new JTextArea(10, 10);
		sortpanel.add(group3Text);
		mainpanel.add(bottonpanel);
		mainpanel.add(sortpanel);
		CreateGroup1 = new JButton("Create Group 1");
		CreateGroup1.addActionListener(this);
		bottonpanel.add(CreateGroup1);
		CreateGroup2 = new JButton("Create Group 2");
		CreateGroup2.addActionListener(this);
		bottonpanel.add(CreateGroup2);
		CreateGroup3 = new JButton("Create Group 3");
		CreateGroup3.addActionListener(this);
		bottonpanel.add(CreateGroup3);
		
		add(mainpanel);
		
	}
	

	public void actionPerformed(ActionEvent arg0) {
		
		//Prompt user to Add Group Name
		if (arg0.getActionCommand().equals("Create Group 1")) {
		groupName1 = JOptionPane.showInputDialog(null,"Enter Group Name");
		
		tasks = new ArrayList<Task>();
		
		group1Tasks = new ArrayList<String>();
		
		CreateGroup1.setText(groupName1);
		
		//Capture all of the tasks for the user
		Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		Task task = new Task(0, "Clean Room", "This is a test Task", dueDate, 0, 0);
		Task task2 = new Task(0, "Wash Car", "This is a test Task", dueDate, 0, 0);
	
		tasks.add(task);
		tasks.add(task2);
		
		
		//Add Buttons with Task Names from tasks arraylist
		for (int i = 0; i < tasks.size(); i++) {
			String taskName = tasks.get(i).getname();
			JButton name = new JButton(taskName);
			name.addActionListener(this);
			mainpanel.add(name);
			mainpanel.validate();
			}
		
		//Need to get user input for which ones they click on, then...
		
		//Populate group1Text field with task names
		for (int i = 0; i < tasks.size(); i++) {
			String name = tasks.get(i).getname();
			group1Tasks.add(name);
			group1Text.setText(group1Text.getText() + "\n" + name);
		}
		
		
		sortpanel.revalidate();
		sortpanel.repaint();
		
		}
		
		if(arg0.getActionCommand().equals("Create Group 2")) {
			groupName2 = JOptionPane.showInputDialog(null,"Enter Group Name");
			
			tasks = new ArrayList<Task>();
			
			group1Tasks = new ArrayList<String>();
			
			CreateGroup2.setText(groupName2);
			
			//Capture all of the tasks for the user
			Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
		
			Task task3 = new Task(0, "Take Out Trash", "This is a test Task", dueDate, 0, 0);
			Task task4 = new Task(0, "Walk Dog", "This is a test Task", dueDate, 0, 0);
		
		
			tasks.add(task3);
			tasks.add(task4);
		
			
			//Add Buttons with Task Names from tasks arraylist
			for (int i = 0; i < tasks.size(); i++) {
				String taskName = tasks.get(i).getname();
				JButton name = new JButton(taskName);
				name.addActionListener(this);
				mainpanel.add(name);
				
				}
			
			//Need to get user input for which ones they click on, then...
			
			//Populate group1Text field with task names
			for (int i = 0; i < tasks.size(); i++) {
				String name = tasks.get(i).getname();
				group1Tasks.add(name);
				group2Text.setText(group2Text.getText() + "\n" + name);
			}
			
			
			sortpanel.revalidate();
			sortpanel.repaint();
			
		}
		
		if(arg0.getActionCommand().equals("Create Group 3")) {
			groupName3 = JOptionPane.showInputDialog(null,"Enter Group Name");
			
			tasks = new ArrayList<Task>();
			
			group3Tasks = new ArrayList<String>();
			
			CreateGroup3.setText(groupName3);
			
			//Capture all of the tasks for the user
			Date dueDate = new Date(2021 - 1900, 4 - 1, 9);
	
			Task task5 = new Task(0, "Do HW", "This is a test Task", dueDate, 0, 0);
			Task task6 = new Task(0, "Buy Soap", "This is a test Task", dueDate, 0, 0);
		
			tasks.add(task5);
			tasks.add(task6);
			
			//Add Buttons with Task Names from tasks arraylist
			for (int i = 0; i < tasks.size(); i++) {
				String taskName = tasks.get(i).getname();
				JButton name = new JButton(taskName);
				name.addActionListener(this);
				mainpanel.add(name);
				
				}
			
			//Need to get user input for which ones they click on, then...
			
			//Populate group1Text field with task names
			for (int i = 0; i < tasks.size(); i++) {
				String name = tasks.get(i).getname();
				group3Tasks.add(name);
				group3Text.setText(group3Text.getText() + "\n" + name);
			}
			
			
			sortpanel.revalidate();
			sortpanel.repaint();
			
		}
		
		
		
	}
	
	
}