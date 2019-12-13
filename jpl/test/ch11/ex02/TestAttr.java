package ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAttr {

	@Test
	void testAttr() {
		Attr<String> stringAttr1 = new Attr<String>("stringAttr1");
		Attr<Number> numberAttr1 = new Attr<Number>("numberAttr1");
		
		assertEquals(null, stringAttr1.getValue(), "Value is null just after created");
		assertEquals(null, numberAttr1.getValue(), "Value is null just after created");
		
		stringAttr1.setValue("string1");
		assertEquals("stringAttr1", stringAttr1.getName());
		assertEquals("string1", stringAttr1.getValue());
		assertEquals("stringAttr1='string1'", stringAttr1.toString());
		
		numberAttr1.setValue(1);
		assertEquals("numberAttr1", numberAttr1.getName());
		assertEquals(1, numberAttr1.getValue());
		assertEquals("numberAttr1='1'", numberAttr1.toString());
		
		/* this causes error */
		// stringAttr1.setValue(1);
		// numberAttr1.setValue("sample string");
	}

}
