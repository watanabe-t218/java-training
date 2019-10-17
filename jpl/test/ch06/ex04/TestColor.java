/**
 * 
 */
package ex04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Watari-Home
 *
 */
class TestColor {

	@Test
	public void testGetColor() {
		Color red = new Color("red");
		assertEquals(EnumTrafficLight.RED.toString(), red.getColorName());
	}

}
