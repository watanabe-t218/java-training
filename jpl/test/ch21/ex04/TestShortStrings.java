package ex04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
class TestShortStrings {

	@Test
	public void test() {
		List<String> strList = Arrays.asList("aaa", "bbb", "cccccc", "ddddd", "eeeee", "f", "gg", "hhhhh", "iiii");
		ShortStrings ss = new ShortStrings(strList.listIterator(), 3);
		
		assertTrue(ss.hasNext());
		String str = ss.next();
		assertTrue("aaa".equals(str));
		
		assertTrue(ss.hasNext());
		str = ss.next();
		assertTrue("bbb".equals(str));
		
		assertTrue(ss.hasNext());
		str = ss.next();
		assertTrue("f".equals(str));
		
		assertTrue(ss.hasNext());
		str = ss.next();
		assertTrue("gg".equals(str));
		
		assertTrue(!ss.hasNext());
		assertTrue(ss.hasPrevious());
		str = ss.previous();
		assertTrue("gg".equals(str));
		
		assertTrue(ss.hasPrevious());
		str = ss.previous();
		assertTrue("f".equals(str));
			
	}

}

