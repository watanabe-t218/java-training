package ex06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEnergySource {

	@Test
	public void testEmptyGasTank() {
		EnergySource gt = new GasTank(1000);
		assertFalse(gt.empty());
		gt.setEnergy(10);
		assertFalse(gt.empty());
		assertEquals(10L, gt.getEnergyAmount());
	}

	@Test
	public void testEmptyBattery() {
		EnergySource bt = new Battery(1000);
		assertFalse(bt.empty());
		bt.setEnergy(10);
		assertFalse(bt.empty());
		assertEquals(10L, bt.getEnergyAmount());
	}
}
