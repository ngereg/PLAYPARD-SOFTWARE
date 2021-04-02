import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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

public class appintro extends JFrame implements ActionListener {
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
		if (arg0.getActionCommand().equals("Log in")) {
			String userid = uid.getText();
			String password = pwd.getText();
			try {
				if (validateAccount(userid, password)) {
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
				if (!validateUserName(userid)) {
					Account account = new Account(userid, password);
					System.out.println(account.toString());
					FileWriter fw = new FileWriter(new File("accounts.txt"), true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter write = new PrintWriter(bw);
					write.print(account.toString());
				} else {
					System.out.println("Already have same user name.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean validateAccount(String userid, String password) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("accounts.txt"));
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(",");
			String tempAccount = array[0];
			String tempPWD = array[1];
			if (tempAccount.equals(userid) && tempPWD.equals(password)) {
				return true;
			}
		}
		return false;
	}

	private boolean validateUserName(String userid) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("accounts.txt"));
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(",");
			String tempAccount = array[0];
			if (tempAccount.equals(userid)) {
				return true;
			}
		}
		return false;
	}
}
