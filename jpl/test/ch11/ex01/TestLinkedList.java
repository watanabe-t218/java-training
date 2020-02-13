package ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLinkedList {

	@Test
	void testLinkedList() {
		LinkedListCh12<String> stringList = new LinkedListCh12<String>();
		LinkedListCh12<Number> numberList = new LinkedListCh12<Number>();
		
		assertEquals(null, stringList.getHead(), "生成直後は空であること");
		assertEquals(null, numberList.getHead(), "生成直後は空であること");
		
		stringList.add("string 0");
		stringList.add("string 1");
		stringList.add("string 2");
		assertEquals("string 0", stringList.getNode(0).getItem());
		assertEquals("string 1", stringList.getNode(1).getItem());
		assertEquals("string 2", stringList.getNode(2).getItem());
		assertEquals("string 0\nstring 1\nstring 2", stringList.toString());
		assertEquals(3, stringList.size());
		
		/* this causes error */
		// stringList.add(1)
		
		numberList.add(0);
		numberList.add(1);
		numberList.add(2);
		assertEquals(0, numberList.getNode(0).getItem());
		assertEquals(1, numberList.getNode(1).getItem());
		assertEquals(2, numberList.getNode(2).getItem());
		assertEquals("0\n1\n2", numberList.toString());
		assertEquals(3, numberList.size());
		
		/* this causes error */
		// numberList.add("sample string")
	}

}
