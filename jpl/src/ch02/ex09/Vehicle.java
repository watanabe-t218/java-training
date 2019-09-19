package ex09;

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
	
	static long getMaxId() {
		return nextId - 1;
	}
}
