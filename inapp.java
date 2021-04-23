

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
 * 
 * @author ruitong sun, Yueheng Han
 *
 */

public class inapp extends JFrame implements ActionListener{
	private JTextField uid, pwd;
	private JPanel bottonpanel, mainpane,sortpanel,sortbottonpanel;
	private JTextArea sortresult;
	private JButton Creat, Search, Sort, CreateGroup, ck,sortbyname,sortbyprior,sortbyprogres;
	Account mainaccount ;
	String username;
	
	public inapp(Account account) {
		mainaccount=account;
		mainpane = new JPanel();
		bottonpanel = new JPanel();
		bottonpanel.setBorder(new TitledBorder("function"));
		Creat = new JButton("Create task");
		Search = new JButton("Search task");
		Sort = new JButton("Sort");
		CreateGroup = new JButton("Create Group");
		ck = new JButton("Check task progress");
		bottonpanel.add(Creat);
		Creat.addActionListener(this);
		bottonpanel.add(Search);
		Search.addActionListener(this);
		bottonpanel.add(Sort);
		Sort.addActionListener(this);
		bottonpanel.add(CreateGroup);
		CreateGroup.addActionListener(this);
		bottonpanel.add(ck);
		ck.addActionListener(this);
		bottonpanel.setBorder(new TitledBorder(""));
		username = account.getUserName();
		add(mainpane);
		mainpane.add(bottonpanel);
		bottonpanel.setPreferredSize(new Dimension(380, 100));
	}
	
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
}
}