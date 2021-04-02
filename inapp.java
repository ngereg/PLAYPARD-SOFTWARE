

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

public class inapp extends JFrame implements ActionListener{
	private JTextField uid, pwd;
	private JPanel bottonpanel, mainpane;
	private JButton Creat, Search, Generate, Set, ck;
	
	public inapp() {
		mainpane = new JPanel();
		bottonpanel = new JPanel();
		bottonpanel.setBorder(new TitledBorder("function"));
		Creat = new JButton("Create task");
		Search = new JButton("Search task");
		Generate = new JButton("Generate time line");
		Set = new JButton("Set task reminder");
		ck = new JButton("Check task progress");
		bottonpanel.add(Creat);
		Creat.addActionListener(this);
		bottonpanel.add(Search);
		Search.addActionListener(this);
		bottonpanel.add(Generate);
		Generate.addActionListener(this);
		bottonpanel.add(Set);
		Set.addActionListener(this);
		bottonpanel.add(ck);
		ck.addActionListener(this);
		bottonpanel.setBorder(new TitledBorder(""));

		add(mainpane);
		mainpane.add(bottonpanel);
		bottonpanel.setPreferredSize(new Dimension(380, 100));
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