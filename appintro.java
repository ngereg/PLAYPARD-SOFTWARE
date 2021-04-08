import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class appintro extends JFrame implements ActionListener {
	private JLabel username, password, newusername, newpassword, error;
	private JTextField uid, pwd, nuid, npwd;
	private JPanel panel, bottonpanel, mainpane, panel2, panel3;
	private JButton login, signup, finish;

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
				if (userid.equals("") || password.equals("")) {
					panel3 = new JPanel();
					error = new JLabel("username or password can't be null");
					panel3.add(error);
					mainpane.add(panel3);
					this.setSize(400, 230);
				} else if (Account.validateAccount(new Account(userid, password))) {
					System.out.println("log in success");
					this.setVisible(false);
					inapp a = new inapp();
					a.setSize(400, 150);
					a.setTitle("FREEMIO");
					a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					a.setVisible(true);
				} else {
					System.out.println("invalid username or password");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		if (arg0.getActionCommand().equals("Sign up")) {
			this.setSize(400, 300);
			newusername = new JLabel("New Username:                                     ");
			nuid = new JTextField(10);
			newpassword = new JLabel("New Password:                                      ");
			npwd = new JTextField(10);
			panel2 = new JPanel();
			panel2.add(newusername);
			panel2.add(nuid);
			panel2.add(newpassword);
			panel2.add(npwd);
			finish = new JButton("finish");
			panel2.add(finish);
			finish.addActionListener(this);
			mainpane.add(panel2);
			panel2.setPreferredSize(new Dimension(380, 100));
		} 
		if (arg0.getActionCommand().equals("finish")) {
			String userid = nuid.getText();
			String password = npwd.getText();
			try {
				if (userid.equals("") || password.equals("")) {
					panel3 = new JPanel();
					error = new JLabel("username or password can't be null");
					panel3.add(error);
					mainpane.add(panel3);
					this.setSize(400, 350);
				} else if (Account.validateUserName(userid)) {
					Account account = new Account(userid, password);
					FileWriter fw = new FileWriter(new File("accounts.txt"), true);
					PrintWriter pw = new PrintWriter(fw);
					String temp = account.toString();
					System.out.println(temp);
					pw.println(temp);
					pw.close();
					this.setSize(400, 200);
				} else {
					System.out.println("Already have same user name.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}