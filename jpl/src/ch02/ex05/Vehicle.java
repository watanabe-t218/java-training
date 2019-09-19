package ex05;

/**
 * @author takahiro watanabe
 *
 */
public class Vehicle {
	private final long id;	// ID has to be exist & immutable
	static long nextId;
	
	public String userName;
	public double velocity;
	public double[] direction;
	
	public Vehicle(long id, long nextId, String userName, double velocity, double[] direction) {
		this.id = id;
		this.nextId = nextId;
		this.userName = userName;
		this.velocity = velocity;
		this.direction = direction;
	}
	
	public void showData() {
		System.out.println(
				"ID: \t" 		+ this.id + "\n" + 
				"User: \t" 		+ this.userName + "\n" +
				"Velocity: \t" 	+ this.velocity + "\n" +
				"Direction: \t{ " + this.direction[0] + ", "
								  + this.direction[1] + ", "
								  + this.direction[2] + " }\n");
	}
	
	public static void main(String[] args) {
		int vehicleNum = 10;
		
		Vehicle[] vehicles = new Vehicle[vehicleNum];
		
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
		}
		
		for(int i = 0; i < vehicles.length; i++) {
			vehicles[i].showData();
		}
	}
}
