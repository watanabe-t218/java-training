package ex14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWalkman {
	
	@Test
	void testWalkman() {
		int serial = 0;
		Walkman walkman = new Walkman(serial);
		walkman.play();
		assertEquals(serial, walkman.serial);
		assertEquals(1, walkman.terminal);
	}

}
