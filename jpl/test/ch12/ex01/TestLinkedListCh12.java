package ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLinkedListCh12 {

	@Test
	void testLinkedList() {
		LinkedListCh12<String> stringList = new LinkedListCh12<String>();
		
		assertEquals(null, stringList.getHead(), "ê∂ê¨íºå„ÇÕãÛÇ≈Ç†ÇÈÇ±Ç∆");
		
		stringList.add("string 0");
		stringList.add("string 1");
		stringList.add("string 2");
		assertEquals("string 0", stringList.getNode(0).getItem());
		assertEquals("string 1", stringList.getNode(1).getItem());
		assertEquals("string 2", stringList.getNode(2).getItem());
		
		// test for find method
		try {
			assertEquals(stringList.getNode(0), stringList.find("string 0"));
		} catch (ObjectNotFoundException e) {
		} 
		
		// test for ObjectNotFoundException
		try {
			stringList.find("string not exists");
		} catch (ObjectNotFoundException e) {
			assertEquals(e.item, "string not exists");
		} 
		
		
		
		
		
	}

}


