package ex17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx17 {
	final static double PI = 3.1415926535;
	// test turn(angle)
	@Test
	public void testTurnByAngle() {
		Vehicle vehicle = new Vehicle();
		vehicle.turn(PI);
		assertEquals(PI, vehicle.getAngle());
	}

	// test turn(TURN_LEFT)
	// test turn(TURN_RIGHT)
	@Test
	public void testTurnByLR() {
		Vehicle vehicle = new Vehicle();
		vehicle.turn(Vehicle.TURN_LEFT);
		assertEquals(3*PI/2, vehicle.getAngle());
		vehicle.turn(Vehicle.TURN_RIGHT);
		assertEquals(0.0, vehicle.getAngle());
	}
}
