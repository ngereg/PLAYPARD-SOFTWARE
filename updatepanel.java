import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 * panel update the task chosen by user
 * @author ruitong
 *
 */
public class updatepanel extends JFrame implements ActionListener {
	private JLabel updateprint,progressprint;
	private JTextField taskname,progress;
	private JPanel panel,panel1,mainpanel;
	private JButton updatebutton;
	private JTextArea information;
	String task,name;
	int newpro;
	
	public updatepanel(Account account) throws FileNotFoundException {
		panel=new JPanel();
		mainpanel=new JPanel();
		updateprint = new JLabel("Please Enter your task name");
		taskname = new JTextField(10);
		progressprint= new JLabel("please Enter your new progres");
		progress = new JTextField(10);
		updatebutton=new JButton("Update");
		updatebutton.addActionListener(this);
		panel.add(updateprint);
		panel.add(taskname);
		panel.add(progressprint);
		panel.add(progress);
		panel.add(updatebutton);
		mainpanel.add(panel);
		add(mainpanel);
		name=account.getUserName();
		}
		
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Update")) {
			task=taskname.getText();
			newpro=Integer.parseInt(progress.getText());  
			
			File file= new File(name+".txt");
			try {
				Task.updateProgress(task, file, newpro);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("update success");
		}
	}
	
}
