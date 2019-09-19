package ex05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx05 {

	// can generate Vehicle
	// can showData();
	@Test
	void test() {
		long id = 0;
		long nextId = 1;
		
		String userName = "user1";
		double velocity = 1.0;
		double[] direction = {1.0, 2.0, 3.0};
		
		Vehicle vehicle = new Vehicle(id, nextId, userName, velocity, direction);
		
		assertEquals(nextId, vehicle.nextId);
		assertEquals(userName, vehicle.userName);
		assertEquals(velocity, vehicle.velocity);
		assertEquals(direction, vehicle.direction);

		assertDoesNotThrow(()->{vehicle.showData();});
	}

}
