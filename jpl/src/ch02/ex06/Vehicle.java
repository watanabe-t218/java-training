package ex06;

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
}
