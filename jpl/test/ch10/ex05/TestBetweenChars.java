package ex05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBetweenChars {

	@Test
	void test() {
		BetweenChars betweenChars = new BetweenChars();
		
		String ans1 = betweenChars.betweenChars('b', 'h');
		assertEquals("bcdefgh", ans1);
		
		String ans2 = betweenChars.betweenChars('A', 'h');
		assertEquals("Please input lowercase alphabet\n", ans2);
		
		String ans3 = betweenChars.betweenChars('h', 'b');
		assertEquals("No Chars between [h] and [b]\n", ans3);
	}

}
