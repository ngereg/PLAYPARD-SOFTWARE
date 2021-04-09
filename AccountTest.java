
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testAccount() {
		Account account1 = new Account();
		assertEquals(null, account1.getUserName());
		assertEquals(null, account1.getPassWord());
		Account account2 = new Account("Yueheng", "010628");
		assertEquals("Yueheng", account2.getUserName());
		assertEquals("010628", account2.getPassWord());
	}

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

	@Test
	public void testValidateAccount() throws FileNotFoundException {
		Account validAccount = new Account("Yueheng", "010628");
		assertTrue(Account.validateAccount(validAccount));
		Account invalidAccount = new Account("INVALID", "INVALID");
		assertFalse(Account.validateAccount(invalidAccount));
	}

	@Test
	public void testValidateUserName() throws FileNotFoundException {
		Account validAccount = new Account("Yueheng", "010628");
		assertFalse(Account.validateUserName(validAccount.getUserName()));
		Account invalidAccount = new Account("INVALID", "INVALID");
		assertTrue(Account.validateUserName(invalidAccount.getUserName()));
	}

	@Test
	public void testToString() {
		Account account = new Account("Yueheng", "010628");
		assertEquals("Yueheng,010628", account.toString());
	}

}
