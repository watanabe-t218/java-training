/**
 * 
 */
package ex08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author takahiro watanabe
 *
 */
class TestPassengerVehicle {

	@Test
	void testClone() {
		PassengerVehicle vehicle1 = new PassengerVehicle("aaa", 12, 1);		
		PassengerVehicle vehicle2 = vehicle1.clone();
		System.out.println(vehicle1.toString());
		System.out.println(vehicle2.toString());
		
		// id is not equal
		assertNotEquals(vehicle1.toString(), vehicle2.toString());
	}

}
