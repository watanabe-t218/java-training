package ex06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMoneyFormat {

	@Test
	void testoneyFormat() {
		
		
		String before = "1234567890";
		String after = "12/34/56/78/90";
		
		MoneyFormatConvert mf = new MoneyFormatConvert();	
		assertEquals(after, mf.makeMoneyFormat(before, 2, '/'));
	}
}
