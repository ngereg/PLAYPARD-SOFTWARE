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
		
		File file = new File(username + ".txt");
		ArrayList<Task> tasks = null;
		try {
			tasks = Task.loadFromFile(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Add Buttons with Task Names for User
		for (int i = 0; i < tasks.size(); i++) {
			String taskName = tasks.get(i).getname();
			JButton name = new JButton(taskName);
			name.addActionListener(this);
			mainpanel.add(name);
			mainpanel.validate();
			}

		add(mainpanel);
		
	}
	

	
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("Create Group 1")) {
			
		groupName1 = JOptionPane.showInputDialog(null,"Enter Group Name");
		
		CreateGroup1.setText(groupName1);
		
		
		sortpanel.revalidate();
		sortpanel.repaint();
		
		}
		
		else if(arg0.getActionCommand().equals("Create Group 2")) {
			
			groupName2 = JOptionPane.showInputDialog(null,"Enter Group Name");
			
			tasks = new ArrayList<Task>();
			
			
			CreateGroup2.setText(groupName2);
			
			
			sortpanel.revalidate();
			sortpanel.repaint();
			
		}
		
		else if(arg0.getActionCommand().equals("Create Group 3")) {
			
			groupName3 = JOptionPane.showInputDialog(null,"Enter Group Name");
			
			tasks = new ArrayList<Task>();
			
			
			CreateGroup3.setText(groupName3);
			
			
			sortpanel.revalidate();
			sortpanel.repaint();
			
		}
		
		else {
		JButton button = (JButton) arg0.getSource();
		String task  = button.getLabel();
		
		Object[] possibleValues = { groupName1, groupName2, groupName3 };
		String groupSelection = (String) JOptionPane.showInputDialog(null,
		"Select Which Group To Add Task", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		
		
		
		if(groupSelection.equalsIgnoreCase(groupName1)) {
			group1Text.append(task + "\n");		
		}
		
		if(groupSelection.equalsIgnoreCase(groupName2)) {
			group2Text.append(task + "\n");		
		}
			
		if(groupSelection.equalsIgnoreCase(groupName3)) {
			group3Text.append(task + "\n");		
		}
		}
		
	}
	
	
}