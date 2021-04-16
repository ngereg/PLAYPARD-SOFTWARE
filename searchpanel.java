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

public class searchpanel extends JFrame implements ActionListener {
	private JLabel searchprint;
	private JTextField taskname;
	private JPanel panel,panel1,mainpanel;
	private JButton searchbutton;
	private JTextArea information;
	String id,name,description,year,month,day,prity,progress,searchCond,username;

	public searchpanel (Account account) throws FileNotFoundException {
		mainpanel=new JPanel();
		panel = new JPanel();
		
		searchprint = new JLabel("Please inter your task name");
		taskname = new JTextField(10);
		
		panel.add(searchprint);
		panel.add(taskname);
		searchbutton=new JButton("search");
		searchbutton.addActionListener(this);
		panel.add(searchbutton);
		username=account.getUserName();
		mainpanel.add(panel);
		add(mainpanel);
		panel.setPreferredSize(new Dimension(380, 100));
		}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("search")) {
			String searchresult = "";
			searchCond = taskname.getText();
			Scanner reader = null;
			try {
				reader = new Scanner(new File(username+".txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			ArrayList<Task> result = Task.search(reader, searchCond);
			
			for(int i = 0; i < result.size(); i++) {   
				searchresult = searchresult + result.get(i).toString() + "\n";
			}
			information=new JTextArea(100, 100);
			information.setText(searchresult);
			System.out.print(searchresult);
			panel1=new JPanel();
			panel1.add(information);
			mainpanel.add(panel1);
			this.setSize(400, 350);
		}
	}
}


