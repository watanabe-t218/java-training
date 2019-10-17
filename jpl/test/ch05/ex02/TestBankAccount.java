package ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex02.BankAccount.Action;
import ex02.BankAccount.History;

class TestBankAccount {

	final static long ACCOUNT_NUMBER = 1234;
	
	@Test
	void testHistory() {
		BankAccount ba = new BankAccount(ACCOUNT_NUMBER);
		for (int i = 0; i < 10; i++) {
			ba.deposit(10000L);
		}
		
		ba.withdraw(2000L);
		History history = ba.history();
		System.out.println(history);
		Action action = ba.new Action("deposit", 10000L);
		Action wdAction = ba.new Action("withdraw", 2000L);
		assertEquals(history.next().toString(), wdAction.toString());
	}

}
