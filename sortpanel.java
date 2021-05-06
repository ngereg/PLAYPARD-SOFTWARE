import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * sort all task in differnt ways
 * @author ruitong
 *
 */
public class sortpanel extends JFrame implements ActionListener {
	private JTextField uid, pwd;
	private JPanel bottonpanel, mainpanel, sortpanel, sortbottonpanel;
	private JTextArea sortresult;
	private JButton Creat, Search, Sort, Set, ck, sortbyname, sortbyprior, sortbyprogres;
	Account mainaccount;
	String username;

	public sortpanel(Account account) {
		mainpanel=new JPanel();
		mainaccount=account;
		bottonpanel=new JPanel();
		sortpanel = new JPanel();
		sortresult = new JTextArea(30, 10);
		sortpanel.add(sortresult);
		sortbottonpanel = new JPanel();
		sortbyname = new JButton("Sort by Name");
		sortbyname.addActionListener(this);
		sortbyprior = new JButton("Sort by Priority");
		sortbyprior.addActionListener(this);
		sortbyprogres = new JButton("Sort by Progress");
		sortbyprogres.addActionListener(this);
		username=account.getUserName();
		bottonpanel.add(sortbyname);
		bottonpanel.add(sortbyprior);
		bottonpanel.add(sortbyprogres);
		
		mainpanel.add(bottonpanel);
		mainpanel.add(sortpanel);
		add(mainpanel);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		String finalresult = "";
		File file = new File(username + ".txt");
		if (arg0.getActionCommand().equals("Sort by Name")) {
			ArrayList<Task> result = null;
			try {
				result = Task.sortByName(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < result.size(); i++) {
				finalresult = finalresult + result.get(i).toString() + "\n";
			}
			sortresult.setText(finalresult);
		}
		if (arg0.getActionCommand().equals("Sort by Priority")) {
			ArrayList<Task> result = null;
			try {
				result = Task.sortByPriority(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < result.size(); i++) {
				finalresult = finalresult + result.get(i).toString() + "\n";
			}
			sortresult.setText(finalresult);
		}
		if (arg0.getActionCommand().equals("Sort by Progress")) {
			ArrayList<Task> result = null;
			try {
				result = Task.sortByProgress(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < result.size(); i++) {
				finalresult = finalresult + result.get(i).toString() + "\n";
			}
			sortresult.setText(finalresult);
		}

	}
}
