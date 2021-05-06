import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Account object and functions
 * @author ruitong sun, Yueheng Han
 *
 */
public class Account {
	private String userName;
	private String passWord;
	
	/**
	 * Empty constructor
	 */
	public Account() {
		this(null, null);
	}
	
	/**
	 * Account constructor
	 * @param userName Account user name
	 * @param passWord Account password
	 */
	public Account(String userName, String passWord) {
		this.passWord = passWord;
		this.userName = userName;
	}
	
	// getter and setter methods
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
	
	/**
	 * Validate account with match user name and password
	 * @param account user name and password given by user input
	 * @return true is account is validate, false otherwise
	 * @throws FileNotFoundException
	 */
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
	
	/**
	 * Helper method to check whether the user name is exist when new user sign up
	 * @param userid the user name which new user want to sign up
	 * @return true is user name do not exist, false otherwise
	 * @throws FileNotFoundException
	 */
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
	
	/**
	 * parse the object to string
	 */
	public String toString() {
		return userName + "," + passWord;
	}
}