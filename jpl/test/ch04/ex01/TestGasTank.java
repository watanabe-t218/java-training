package ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGasTank {

	@Test
	void test() {
		GasTank gastank = new GasTank(0);	
		assertEquals(true, gastank.empty());
		
		gastank.setEnergy(100);
		assertEquals(false, gastank.empty());
	}

}
