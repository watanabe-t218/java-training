package ex16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex15.Vehicle;

class TestLinkedListEx16 {

	@Test
	void testCountListObject() {
int vehicleNum = 10;
		
		Vehicle[] vehicles = new Vehicle[vehicleNum];
		
		// generate first linked list
		LinkedList start = new LinkedList(null);
		LinkedList end = new LinkedList(null);
		start.setNext(end);
		
		for(int i = 0; i < vehicleNum; i++) {
			long id;
			if(i == 0) {
				id = 0;
			} else {
				id = vehicles[i-1].getNextId();
			}
			
			double direction[] = {(double)i, (double)i, (double)i};
			vehicles[i] = new Vehicle();
			
			end.setData(vehicles[i]);
			end.setNext(new LinkedList(null));
			end = end.getNext();
		}
		
		// test generate list succes
		LinkedList index = start.getNext();
		for(int i = 0; i < vehicleNum; i++) {
			assertNotNull(vehicles[i]);
			assertNotNull(index.getData());
			index = index.getNext();
		}
		
	}

}
