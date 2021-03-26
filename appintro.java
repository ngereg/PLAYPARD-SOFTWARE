
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 * 
 * @author ruitong sun
 *
 */

public class appintro extends JFrame {
	private JLabel username,password;
	private JTextField usernamepage, passwordpage;
	private JPanel panel,panel1,mainpanel;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		appintro a= new appintro();
		a.setSize(400, 180);
		a.setTitle("FREEMIO");
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setVisible(true);
		
	}
	public appintro(){
		//making the value for input
		username= new JLabel("Username:                           ");
		usernamepage = new JTextField(10);
		password = new JLabel("Password:                           ");
		passwordpage = new JTextField(10);
		mainpanel = new JPanel();
		panel=new JPanel();
		panel.add(username);
		panel.add(usernamepage);
		panel.add(password);
		panel.add(passwordpage);
		panel.setBorder(new TitledBorder("Plase login"));
		panel1=new JPanel();
		mainpanel.add(panel);
		panel.setPreferredSize(new Dimension(380,130));
		panel1.setPreferredSize(new Dimension(380,130));
		add(mainpanel);
	}


}
