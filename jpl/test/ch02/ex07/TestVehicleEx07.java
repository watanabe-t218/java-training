package ex07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx07 {

	@Test
	void test() {
		String userName = "user2";
		
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle(userName);
		
		// could generate Vehicle
		assertNotNull(vehicle1);
		assertNotNull(vehicle2);
		
		// test generate unique id
		assertNotEquals(vehicle1.getId(), vehicle2.getId());
		
		// correctly set userName
		assertEquals(userName, vehicle2.userName);
		
	}

}
