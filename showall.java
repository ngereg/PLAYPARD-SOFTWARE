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
 * panel showing all user's task
 * @author ruitong
 *
 */
public class showall extends JFrame implements ActionListener {
	private JLabel searchprint;
	private JTextField taskname;
	private JPanel panel,panel1,mainpanel;
	private JButton searchbutton;
	private JTextArea information;
	String result="";
	
	public showall(Account account) throws FileNotFoundException {
		mainpanel=new JPanel();
		information=new JTextArea(30, 30);
		Scanner reader = new Scanner(new File(account.getUserName()+".txt"));
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			result=result+temp+"\n";
		}
		mainpanel.add(information);
		information.setText(result);
		add(mainpanel);
		}
		
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
