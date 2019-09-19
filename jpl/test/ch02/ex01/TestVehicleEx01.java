package ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx01 {

	@Test
	void testVehicle() {
		String userName = "user1";
		double velocity = 1.0;
		double[] direction = {1.0, 2.0, 3.0};
		
		Vehicle vehicle = new Vehicle(userName, velocity, direction);
		
		assertEquals(userName, vehicle.userName);
		assertEquals(velocity, vehicle.velocity);
		assertEquals(direction, vehicle.direction);
	}

}
