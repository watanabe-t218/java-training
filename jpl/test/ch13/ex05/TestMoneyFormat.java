package ex05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMoneyFormat {

	@Test
	void testoneyFormat() {
		
		String before = "123456789";
		String after = "123,456,789";
		
		MoneyFormatConvert mf = new MoneyFormatConvert();	
		assertEquals(after, mf.makeMoneyFormat(before));
	}

}
