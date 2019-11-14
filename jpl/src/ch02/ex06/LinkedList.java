package ex06;

/**
 * @author Watari-Home
 *
 */
public class LinkedList {
	public Object data;
	public LinkedList next;
	
	public LinkedList(Object data) {
		this.data = data;
		this.next = null;
	}
	
	public static void main(String[] args) {
		int vehicleNum = 10;
		
		VehicleEx06[] vehicles = new VehicleEx06[vehicleNum];
		
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
			vehicles[i] = new VehicleEx06(
					id, 		// id
					i + 1, 		// nextId
					"user" + i, // userName
					i, 			// velocity
					direction);	// direction
			
			end.data = vehicles[i];
			end.next = new LinkedList(null);
			end = end.next;
		}
		
		LinkedList index = start.next;
		while(index.data != null) {
			VehicleEx06 nowVehicle = (VehicleEx06) index.data;
			System.out.println(nowVehicle);
			nowVehicle.showData();
			index = index.next;
		}
	}
}
