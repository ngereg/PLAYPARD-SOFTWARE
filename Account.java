import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author ruitong sun, Yueheng Han
 *
 */
public class Account {
	private String userName;
	private String passWord;
	
	public Account() {
		this(null, null);
	}

	public Account(String userName, String passWord) {
		this.passWord = passWord;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public static boolean validateAccount(Account account) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("accounts.txt"));
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(",");
			String tempAccount = array[0];
			String tempPWD = array[1];
			if (tempAccount.equals(account.getUserName()) && tempPWD.equals(account.getPassWord())) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateUserName(String userid) throws FileNotFoundException {
		Scanner reader = new Scanner(new File("accounts.txt"));
		while (reader.hasNextLine()) {
			String temp = reader.nextLine();
			String[] array = temp.split(",");
			String tempAccount = array[0];
			if (tempAccount.equals(userid)) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		return userName + "," + passWord;
	}
}
