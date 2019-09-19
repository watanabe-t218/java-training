package ex03;

/**
 * @author takahiro watanabe
 *
 */
public class Vehicle {
	private long id;
	static long nextId;
	
	public String userName;
	public double velocity;
	public double[] direction;
	
	public Vehicle(String userName, double velocity, double[] direction) {
		this.userName = userName;
		this.velocity = velocity;
		this.direction = direction;
	}
}
