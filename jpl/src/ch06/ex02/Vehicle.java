package ex02;

/**
 * @author takahiro watanabe
 * 
 */
public class Vehicle {
	final static double PI = 3.1415926535;
	
	enum EnumDirection {
		TURN_RIGHT, TURN_LEFT
	}
	
	private final long id;		// ID has to be exist & immutable {get;}
	static long nextId = 0;		// {get; set;}
	
	private String userName;	// {get; set;}
	private double velocity;	// {get; set;}
	private double angle;		// [rad] {get; set;}
	
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

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		while(angle < 0) {
			angle += (2 * PI);
		}
		this.angle = angle % (2 * PI);
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
	public void turn(EnumDirection turnDirection) {
		double angleRaw = 0.0;
		if(turnDirection == EnumDirection.TURN_LEFT) {
			angleRaw = this.angle - PI / 2.0;
		}
		else if(turnDirection == EnumDirection.TURN_RIGHT) {
			angleRaw = this.angle + PI / 2.0;
		}
		this.setAngle(angleRaw);
	}

}
