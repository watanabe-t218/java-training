package ex10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestVehicleEx10 {

	@Test
	void testToString() {
		
		Vehicle vehicle1 = new Vehicle(); //id: 0
		vehicle1.direction = new double[] {0.0, 0.0, 0.0};
		
		// can execute toString()
		assertDoesNotThrow(()->{vehicle1.toString();}, "test toString() execute");
	}

}
