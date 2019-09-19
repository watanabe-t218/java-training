package ex14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTape {

	@Test
	void testGetMusic() {
		Tape tape = new Tape();
		assertEquals("music", tape.getMusic());
	}

}
