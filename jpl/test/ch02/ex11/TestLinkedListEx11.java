package ex11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex10.Vehicle;

class TestLinkedListEx11 {

	@Test
	void testToString() {
		LinkedList linkedList = new LinkedList();
		
		// can execute toString()
		assertDoesNotThrow(()->{linkedList.toString();}, "test toString() execute");
	
	}

}
