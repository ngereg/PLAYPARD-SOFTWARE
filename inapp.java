
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
 * the main panel after user login
 * 
 * @author ruitong sun, Yueheng Han
 *
 */

public class inapp extends JFrame implements ActionListener {
	private JTextField uid, pwd;
	private JPanel bottonpanel, mainpane, sortpanel, sortbottonpanel;
	private JTextArea sortresult;
	private JButton Creat, Search, Sort, CreateGroup, ck, sortbyname, sortbyprior, sortbyprogres, showall, update, reminder;
	Account mainaccount;
	String username;

	/**
	 * main interface
	 * 
	 * @param account
	 */
	public inapp(Account account) {
		mainaccount = account;
		mainpane = new JPanel();
		bottonpanel = new JPanel();
		bottonpanel.setBorder(new TitledBorder("function"));
		Creat = new JButton("Create task");
		Search = new JButton("Search task");
		Sort = new JButton("Sort");
		CreateGroup = new JButton("Create Group");
		bottonpanel.add(Creat);
		Creat.addActionListener(this);
		bottonpanel.add(Search);
		Search.addActionListener(this);
		bottonpanel.add(Sort);
		Sort.addActionListener(this);
		bottonpanel.add(CreateGroup);
		CreateGroup.addActionListener(this);
		showall = new JButton("show all");
		showall.addActionListener(this);
		bottonpanel.add(showall);
		update = new JButton("update task");
		update.addActionListener(this);
		
		reminder = new JButton("reminder");
		bottonpanel.add(reminder);
		reminder.addActionListener(this);

		bottonpanel.add(update);
		bottonpanel.setBorder(new TitledBorder(""));
		username = account.getUserName();
		add(mainpane);
		mainpane.add(bottonpanel);
		bottonpanel.setPreferredSize(new Dimension(380, 100));
	}

	/**
	 * Different panel for different button
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Create task")) {
			System.out.println("Creat task");
			creatpanel a = null;
			try {
				a = new creatpanel(mainaccount);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.setSize(1000, 120);
			a.setTitle("FREEMIO");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);
		}
		if (arg0.getActionCommand().equals("Search task")) {
			System.out.println("Search task");
			searchpanel a = null;
			try {
				a = new searchpanel(mainaccount);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.setSize(400, 300);
			a.setTitle("FREEMIO");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);

		}
		if (arg0.getActionCommand().equals("Sort")) {
			System.out.println("Sort task");
			sortpanel a = new sortpanel(mainaccount);
			a.setSize(400, 200);
			a.setTitle("FREEMIO");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);
		}
		if (arg0.getActionCommand().equals("Create Group")) {
			grouppanel a = new grouppanel(mainaccount);
			a.setSize(400, 450);
			a.setTitle("FREEMIO");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);
		}
		if (arg0.getActionCommand().equals("show all")) {
			System.out.println("showall");
			showall a = null;
			try {
				a = new showall(mainaccount);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.setSize(400, 200);
			a.setTitle("FREEMIO");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);
		}
		if (arg0.getActionCommand().equals("update task")) {
			System.out.println("update task");
			updatepanel a = null;
			try {
				a = new updatepanel(mainaccount);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.setSize(800, 100);
			a.setTitle("FREEMIO");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);
		}
		if (arg0.getActionCommand().equals("reminder")) {
			reminder a = new reminder(mainaccount);
			a.setSize(400, 450);
			a.setTitle("reminder");
			a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setVisible(true);
		}
	}
}