/**
 * 
 */
package ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Watari-Home
 *
 */
class TestPassengerVehicle {

	/**
	 * get&set capacity, numPassenger
	 */
	@Test
	void testBasicFunc() {
		
		int testNumPassenger = 12;
		int testCapacity = 24;
		
		PassengerVehicle vehicle1 = new PassengerVehicle("aaa", testCapacity, testNumPassenger);
		assertEquals(testNumPassenger, vehicle1.getNumPassenger());
		assertEquals(testCapacity, vehicle1.getCapacity());

		vehicle1.setNumPassenger(2);
		vehicle1.setCapacity(34);
		assertEquals(2, vehicle1.getNumPassenger());
		assertEquals(34, vehicle1.getCapacity());
	}
	
	@Test
	void testSeatStatus() {
		int testNumPassenger = 12;
		int testCapacity = 24;
		
		PassengerVehicle vehicle1 = new PassengerVehicle("aaa", testCapacity, testNumPassenger);
		String expected = "Capacity: \t" + testCapacity + "\n"
						+ "Passengers: \t" +  testNumPassenger + "\n";
		
		assertEquals(expected, vehicle1.seatStatus());
	}

}
