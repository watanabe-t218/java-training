package ex07;

/**
 * @author takahiro watanabe
 *
 */
public class Vehicle {
	private final long id;	// ID has to be exist & immutable
	public long getId() {
		return id;
	}

	static long nextId = 0;
	
	public String userName;
	public double velocity;
	public double[] direction;
	
	public Vehicle() {
		this.id = this.nextId++;
	}
	
	public Vehicle(String userName) {
		this.id = this.nextId++;
		this.userName = userName;
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
			vehicles[i] = new Vehicle((String)("user" + i));
			vehicles[i].velocity = (double)i;
			vehicles[i].direction = new double[] {(double)i, (double)i, (double)i};
		}
		
		for(int i = 0; i < vehicles.length; i++) {
			vehicles[i].showData();
		}
	}
}
