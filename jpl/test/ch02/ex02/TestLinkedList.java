package ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLinkedList {

	@Test
	void test() {
		Object data = "data";
		LinkedList next = null;
		
		LinkedList linkedList = new LinkedList(data, next);
		
		// can generate LinkedList
		assertNotNull(linkedList);
	}

}
