/**
 * 
 */
package ex07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Watari-Home
 *
 */
class TestColorAttr {

	@Test
	void test() {
		ColorAttr color1 = new ColorAttr("color1");
		System.out.println(color1.hashCode());
		
		ColorAttr color2 = new ColorAttr("color2");
		assertEquals(true, color1.equals(color2));
		
	}

}
