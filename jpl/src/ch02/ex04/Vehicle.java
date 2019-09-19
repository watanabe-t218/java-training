package ex04;

/**
 * @author takahiro watanabe
 *
 */
public class Vehicle {
	private final long id;	// ID has to be exist & immutable
	public static long nextId;
	
	public String userName;
	public double velocity;
	public double[] direction = new double[3];
	
	public Vehicle(long id, long nextId, String userName, double velocity, double[] direction) {
		this.id = id;
		this.nextId = nextId;
		this.userName = userName;
		this.velocity = velocity;
		this.direction = direction;
	}
}
