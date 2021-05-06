import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class creatpanel extends JFrame implements ActionListener{
	private JLabel taskprint,descripprint,dateprint,priorityprint,progressprint,finishprint,info;
	private JTextField taskname,descrip,date,priority,progress;
	private JPanel panel,panel1,infopanel,mainpanel;
	private JButton creatbutton;
	private JTextArea information;
	String id,name,description,year,month,day,prity,searchCond,username;
/**
 * creatpanel which allow use to make new task to there account
 * @param account
 * @throws IOException
 */
	public creatpanel (Account account) throws IOException {
		mainpanel=new JPanel();
		panel = new JPanel();
		infopanel=new JPanel();
		info=new JLabel("INFO:DATE:(Month/Day/Year)   Priority:0 is normal, 1 is emergency  Progress:-1 is finish, 0 is doing, 1 is to do");
		infopanel.add(info);
		taskprint = new JLabel("task name");
		taskname = new JTextField(10);
		descripprint = new JLabel("Description");
		descrip = new JTextField(10);
		dateprint = new JLabel("Date");
		date = new JTextField(10);
		priorityprint = new JLabel("priority");
		priority = new JTextField(10);
		progressprint = new JLabel("progress");
		progress = new JTextField(10);
		
		panel.add(taskprint);
		panel.add(taskname);
		panel.add(descripprint);
		panel.add(descrip);
		panel.add(dateprint);
		panel.add(date);
		panel.add(priorityprint);
		panel.add(priority);
		panel.add(progressprint);
		panel.add(progress);
		
		creatbutton=new JButton("Create");
		creatbutton.addActionListener(this);
		username=account.getUserName();
		panel.add(creatbutton);
		
		mainpanel.add(panel);
		mainpanel.add(infopanel);
		add(mainpanel);
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Create")) {
			File file = new File(username+".txt");
			int priorityint=Integer.parseInt(priority.getText());
			int progressint=Integer.parseInt(progress.getText());
			try {
				Task.createTask(taskname.getText(), descrip.getText(),date.getText() , priorityint, progressint, file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finishprint = new JLabel("Finish creating task, plase close the window or creat another task");
			panel1 = new JPanel();
			panel1.add(finishprint);
			mainpanel.add(panel1);
			this.setSize(1000, 170);
			taskname.setText("");
			descrip.setText("");
			date.setText("");
			priority.setText("");
			progress.setText("");
		}
		
	}

}
