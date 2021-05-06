import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * Junit test of account
 * @author yuehe
 *
 */
public class AccountTest {
	
	/**
	 * test account constructor
	 */
	@Test
	public void testAccount() {
		Account account1 = new Account();
		assertEquals(null, account1.getUserName());
		assertEquals(null, account1.getPassWord());
		Account account2 = new Account("Yueheng", "010628");
		assertEquals("Yueheng", account2.getUserName());
		assertEquals("010628", account2.getPassWord());
	}
	
	/**
	 * test account setters and getters
	 */
	@Test
	public void testGetUserName() {
		Account account = new Account("Yueheng", "010628");
		assertEquals("Yueheng", account.getUserName());
	}

	@Test
	public void testSetUserName() {
		Account account = new Account("Yueheng", "010628");
		assertEquals("Yueheng", account.getUserName());
		account.setUserName("tony");
		assertEquals("tony", account.getUserName());
	}

	@Test
	public void testGetPassWord() {
		Account account = new Account("Yueheng", "010628");
		assertEquals("010628", account.getPassWord());
	}

	@Test
	public void testSetPassWord() {
		Account account = new Account("Yueheng", "010628");
		assertEquals("010628", account.getPassWord());
		account.setPassWord("123456");
		assertEquals("123456", account.getPassWord());
	}
	
	/**
	 * test validate account
	 * @throws FileNotFoundException
	 */
	@Test
	public void testValidateAccount() throws FileNotFoundException {
		Account validAccount = new Account("Yueheng", "010628");
		assertTrue(Account.validateAccount(validAccount));
		Account invalidAccount = new Account("INVALID", "INVALID");
		assertFalse(Account.validateAccount(invalidAccount));
	}
	
	/**
	 * test validate user name
	 * @throws FileNotFoundException
	 */
	@Test
	public void testValidateUserName() throws FileNotFoundException {
		Account validAccount = new Account("Yueheng", "010628");
		assertFalse(Account.validateUserName(validAccount.getUserName()));
		Account invalidAccount = new Account("INVALID", "INVALID");
		assertTrue(Account.validateUserName(invalidAccount.getUserName()));
	}
	
	/**
	 * test parse the object to string
	 */
	@Test
	public void testToString() {
		Account account = new Account("Yueheng", "010628");
		assertEquals("Yueheng,010628", account.toString());
	}

}
