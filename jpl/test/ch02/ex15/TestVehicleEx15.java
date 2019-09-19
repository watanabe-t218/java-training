package ex15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx15 {

	// test changeSpeed()
	@Test
	public void testChangeSpeed() {
		Vehicle vehicle = new Vehicle();
		vehicle.changeSpeed(1.0);
		assertEquals(1.0, vehicle.getVelocity());
	}

	// test stop()
	@Test
	public void testStop() {
		Vehicle vehicle = new Vehicle();
		vehicle.changeSpeed(1.0);
		vehicle.stop();
		assertEquals(0.0, vehicle.getVelocity());
	}

}
