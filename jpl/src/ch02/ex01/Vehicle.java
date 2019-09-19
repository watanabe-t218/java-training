package ex01;

/**
 * @author takahiro watanabe
 *
 */
public class Vehicle {
	public String userName;
	public double velocity;
	public double[] direction;
	
	public Vehicle(String userName, double velocity, double[] direction) {
		this.userName = userName;
		this.velocity = velocity;
		this.direction = direction;
	}
}
