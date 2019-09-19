package ex15;

/**
 * @author takahiro watanabe
 * 
 */
public class Vehicle {
	private final long id;		// ID has to be exist & immutable {get;}
	static long nextId = 0;		// {get; set;}
	
	private String userName;	// {get; set;}
	private double velocity;	// {get; set;}
	private double[] direction;	// {get; set;}
	
	public static long getNextId() {
		return nextId;
	}

	public static void setNextId(long nextId) {
		Vehicle.nextId = nextId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double[] getDirection() {
		return direction;
	}

	public void setDirection(double[] direction) {
		this.direction = direction;
	}

	public long getId() {
		return id;
	}

	/**
	 * Constructor no args
	 * */
	public Vehicle() {
		this.id = Vehicle.nextId++;
	}

	/**
	 * Constructor with userName
	 * @param userName
	 */
	public Vehicle(String userName) {
		this.id = Vehicle.nextId++;
		this.userName = userName;
	}
	
	/**
	 * Show data formatted
	 */
	public void showData() {
		System.out.println(
				"ID: \t" 		+ this.id + "\n" + 
				"User: \t" 		+ this.userName + "\n" +
				"Velocity: \t" 	+ this.velocity + "\n" +
				"Direction: \t{ " + this.direction[0] + ", "
								  + this.direction[1] + ", "
								  + this.direction[2] + " }\n");
	}
	
	/**
	 * @return Max Id used
	 */
	static long getMaxId() {
		return nextId - 1;
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		String desc = 
				"ID: \t" 		+ this.id + "\n" + 
				"User: \t" 		+ this.userName + "\n" +
				"Velocity: \t" 	+ this.velocity + "\n" +
				"Direction: \t{ " + this.direction[0] + ", "
								  + this.direction[1] + ", "
								  + this.direction[2] + " }\n";
		return desc;
	}
	
	/**
	 * Set velocity to
	 * @param velocity
	 */
	public void changeSpeed(double velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * Set velocity to Zero
	 */
	public void stop() {
		this.velocity = 0.0;
	}
}
