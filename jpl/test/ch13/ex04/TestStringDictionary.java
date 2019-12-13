package ex04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestStringDictionary {

	@Test
	void test() {
		String str = ""
				+ "Boolean true\n"
				+ "Character c\n"
				+ "Byte 25\n"
				+ "Short 128\n"
				+ "Integer 1000\n"
				+ "Long 12345678\n"
				+ "Float 1234.56\n"
				+ "Double 1234.567\n";
		
		StringSplit stringSplit = new StringSplit();
		
		List<Object> list = stringSplit.makeList(str);
		assertEquals(true, list.get(0), "Boolean Test");
		assertEquals('c', list.get(1), "Character Test");
		assertEquals((byte)25, list.get(2), "Byte Test");
		assertEquals((short)128, list.get(3), "Short Test");
		assertEquals((int)1000, list.get(4), "Integer Test");
		assertEquals((long)12345678, list.get(5), "Long Test");
		assertEquals((float)1234.56, list.get(6), "Float Test");
		assertEquals((double)1234.567, list.get(7), "Double Test");
	}

}
