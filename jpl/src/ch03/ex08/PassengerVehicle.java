/**
 * 
 */
package ex08;

/**
 * @author takahiro watanabe
 *
 */
public class PassengerVehicle extends Vehicle implements Cloneable{
	
	private int capacity;
	private int numPassenger;
		
	/**
	 * Constructor
	 * 
	 * @param capacity
	 * @param numPassenger
	 */
	public PassengerVehicle(int capacity, int numPassenger) {
		super();
		this.capacity = capacity;
		this.numPassenger = numPassenger;
	}
	
	/**
	 * Constructor with userName
	 * 
	 * @param capacity
	 * @param numPassenger
	 */
	public PassengerVehicle(String userName, int capacity, int numPassenger) {
		super(userName);
		this.capacity = capacity;
		this.numPassenger = numPassenger;
	}


	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getNumPassenger() {
		return numPassenger;
	}


	public void setNumPassenger(int numPassenger) {
		this.numPassenger = numPassenger;
	}

	public PassengerVehicle(String userName) {
		super(userName);
	}
	
	// final
	public final String seatStatus() {	
		return "Capacity: \t" + this.capacity + "\n"
				+ "Passengers: \t" +  this.numPassenger + "\n";
	}
	
	/**
	 * return description
	 */
	@Override
	public String toString() {	
		String desc = super.toString()  
					+ "Capacity: \t" + this.capacity + "\n"
					+ "Passengers: \t" +  this.numPassenger + "\n";
				
		return desc;
	}


	
	/**
	 * clone but id is not equal
	 */
	@Override
	public PassengerVehicle clone(){
		
		PassengerVehicle copy = new PassengerVehicle(this.getUserName(), this.capacity, this.getNumPassenger());
		
		copy.setVelocity(this.getVelocity());
		copy.setAngle(this.getAngle());
		copy.setGasTank(this.getGasTank());
		copy.setBattery(this.getBattery());
		
		return copy;
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		PassengerVehicle vehicle1 = new PassengerVehicle("aaa", 12, 1);
		
		System.out.println(vehicle1.start());
	}

}
