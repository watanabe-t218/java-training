package ex06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEx06 {

	@Test
	void testGenerateList() {
		int vehicleNum = 10;
		
		Vehicle[] vehicles = new Vehicle[vehicleNum];
		
		// generate first linked list
		LinkedList start = new LinkedList(null);
		LinkedList end = new LinkedList(null);
		start.next = end;
		
		for(int i = 0; i < vehicleNum; i++) {
			long id;
			if(i == 0) {
				id = 0;
			} else {
				id = vehicles[i-1].nextId;
			}
			
			double direction[] = {(double)i, (double)i, (double)i};
			vehicles[i] = new Vehicle(
					id, 		// id
					i + 1, 		// nextId
					"user" + i, // userName
					i, 			// velocity
					direction);	// direction
			
			end.data = vehicles[i];
			end.next = new LinkedList(null);
			end = end.next;
		}
		
		// test generate list succes
		LinkedList index = start.next;
		for(int i = 0; i < vehicleNum; i++) {
			assertNotNull(vehicles[i]);
			assertNotNull(index.data);
			index = index.next;
		}
		
		// test showData()
		index = start.next;
		while(index.data != null) {
			Vehicle nowVehicle = (Vehicle) index.data;
			System.out.println(nowVehicle);
			assertDoesNotThrow(()->{nowVehicle.showData();});
			index = index.next;
		}
	}

}
