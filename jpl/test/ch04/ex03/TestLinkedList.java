package ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex15.Vehicle;

class TestLinkedList {

	@Test
	public void testGet() {
		LinkedList list = new LinkedList("1");
		list.add("2");
		list.add("3");

		assertEquals("1", list.get(0));
		assertEquals("2", list.get(1));
		assertEquals("3", list.get(2));
		assertEquals(null, list.get(3));
		
	}
	
	@Test
	public void testClone() {
		LinkedList list = new LinkedList("1");
		Vehicle v = new Vehicle("2");
		list.add(v);
		list.add("3");

		LinkedList copyList = list.clone();

		Vehicle copyVehicle = (Vehicle) copyList.get(1);

		assertEquals("2", ((Vehicle) list.get(1)).getUserName());
		list.add("4");

		assertTrue(list.contains("4"));
		assertFalse(copyList.contains("4"));

	}

}