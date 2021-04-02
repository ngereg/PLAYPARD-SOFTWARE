import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author ruitong sun, Yueheng Han
 *
 */

public class appintro extends JFrame implements ActionListener{
	private JLabel username, password;
	private JTextField uid, pwd;
	private JPanel panel, bottonpanel, mainpane;
	private JButton login, signup;

	public appintro() {
		mainpane = new JPanel();

		panel = new JPanel();
		username = new JLabel("Username:                           ");
		uid = new JTextField(10);
		password = new JLabel("Password:                           ");
		pwd = new JTextField(10);

		panel.add(username);
		panel.add(uid);
		panel.add(password);
		panel.add(pwd);
		panel.setBorder(new TitledBorder("Plase login"));

		bottonpanel = new JPanel();
		login = new JButton("Log in");
		signup = new JButton("Sign up");

		bottonpanel.add(login);
		login.addActionListener(this);
		bottonpanel.add(signup);
		signup.addActionListener(this);
		bottonpanel.setBorder(new TitledBorder(""));

		add(mainpane);
		mainpane.add(panel);
		mainpane.add(bottonpanel);
		panel.setPreferredSize(new Dimension(380, 100));
		bottonpanel.setPreferredSize(new Dimension(380, 50));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		File accounts = new File("xxxx.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(accounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (arg0.getActionCommand().equals("Log in")) {
			String userid = uid.getText();
			String password = pwd.getText();
			try {
				if (validateAccount(accounts, userid, password)) {
					System.out.println("log in success");
				} else {
					System.out.println("invalid username or password");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (arg0.getActionCommand().equals("Sign up")) {
			String userid = uid.getText();
			String password = pwd.getText();
			try {
				if (validateUserName(accounts, userid)) {
					Account account = new Account(userid, password);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw);
					out.println(account.toString());
				} else {
					System.out.println("Already have same user name.");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean validateAccount(File accounts, String userid, String password) throws FileNotFoundException {
		Scanner reader = new Scanner(accounts);
		// while(reader.hasNext()) {
			String temp = reader.nextLine();
			String[] array = temp.split(",");
			String tempAccount = array[0];
			String tempPWD = array[1];
			System.out.println(temp + "111111");
			if (tempAccount.equals(userid) && tempPWD.equals(password)) {
				return true;
			}
		// }
		return false;
	}


	private boolean validateUserName(File accounts, String userid) throws FileNotFoundException {
		Scanner reader = new Scanner(accounts);
		
		return false;
	}
}
