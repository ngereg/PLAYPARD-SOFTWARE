
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		if (arg0.getActionCommand().equals("Log in")) {
			String userid = uid.getText();
			String password = pwd.getText();
			boolean validAcccount = cheakValid(userid, password);
			if (validAcccount) {
				System.out.println("log in success");
			} else {
				System.out.println("invalid username or password");
			}
		} else if (arg0.getActionCommand().equals("Sign up")) {
			System.out.println("sign up success");
		}
	}

	private boolean cheakValid(String uid, String pwd) {
		if (uid.equals("admin") && pwd.equals("admin")) {
			return true;
		}
		return false;
	}

}
