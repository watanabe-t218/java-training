package ex09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx09 {

	@Test
	void testGetMaxId() {
		
		Vehicle vehicle1 = new Vehicle(); //id: 0
		Vehicle vehicle2 = new Vehicle(); //id: 1 <- maxId
		
		// could generate Vehicle
		assertNotNull(vehicle1);
		assertNotNull(vehicle2);
		
		assertEquals(1, Vehicle.getMaxId());
	}

}
