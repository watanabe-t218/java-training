package ex04;

/**
 * @author takahiro watanabe
 * 
 */
public class Vehicle {
	final static double PI = 3.1415926535;
	final static int TURN_LEFT = 0;
	final static int TURN_RIGHT = 1;
	
	private final long id;		// ID has to be exist & immutable {get;}
	static long nextId = 0;		// {get; set;}
	
	private String userName;	// {get; set;}
	private double velocity;	// [m/s] {get; set;}
	private double angle;		// 0 ~ 2*PI [rad] {get; set;}
	
	// final
	public static final long getNextId() {
		return nextId;
	}

	// final
	public static final void setNextId(long nextId) {
		Vehicle.nextId = nextId;
	}
	
	// final
	public final String getUserName() {
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

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		while(angle < 0) {
			angle += (2 * PI);
		}
		this.angle = angle % (2 * PI);
	}

	// final
	public final long getId() {
		return id;
	}
	
	/**
	 * Constructor no args
	 * */
	public Vehicle() {
		this.id = Vehicle.nextId++;
		this.velocity = 0.0;
		this.angle = 0.0;
	}
	
	/**
	 * Constructor with userName
	 * @param userName
	 */
	public Vehicle(String userName) {
		this.id = Vehicle.nextId++;
		this.userName = userName;
		this.velocity = 0.0;
		this.angle = 0.0;
	}

	// final
	/**
	 * @return Max Id used
	 */
	static final long getMaxId() {
		return nextId - 1;
	}
	
	/**
	 * return description
	 */
	@Override
	public String toString() {
		String desc = 
				"ID: \t" 		+ this.id + "\n" + 
				"User: \t" 		+ this.userName + "\n" +
				"Velocity: \t" 	+ this.velocity + "[m/s]\n" +
				"Direction: \t"	+ this.angle + "[rad]\n";
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
	
	/**
	 * turn by rotateAngle
	 * @param rotateAngle
	 */
	public void turn(double rotateAngle) {
		double angleRaw = this.angle + rotateAngle;
		this.setAngle(angleRaw);
	}
	
	/**
	 * turn 90[deg] by turnDirection
	 * @param turnDirection
	 */
	public void turn(int turnDirection) {
		double angleRaw = 0.0;
		if(turnDirection == TURN_LEFT) {
			angleRaw = this.angle - PI / 2.0;
		}
		else if(turnDirection == TURN_RIGHT) {
			angleRaw = this.angle + PI / 2.0;
		}
		this.setAngle(angleRaw);
	}
	
}
