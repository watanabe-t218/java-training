package ex14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWalkman2 {

	@Test
	void testWalkman2() {
		int serial = 0;
		Walkman2 walkman2 = new Walkman2(serial);
		assertDoesNotThrow(()->{walkman2.play();}, "cannnot play()");
		assertEquals(serial, Walkman2.serial);
		assertEquals(1, walkman2.terminal);
		
		assertDoesNotThrow(()->{walkman2.sendMessage(1, "sendFrom1");}, "cannnot sendMessage() from 1");
		assertDoesNotThrow(()->{walkman2.sendMessage(2, "sendFrom2");}, "cannnot sendMessage() from 2");
	}
}
