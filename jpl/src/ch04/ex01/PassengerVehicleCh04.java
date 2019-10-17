/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public class PassengerVehicleCh04 extends VehicleCh04{

	/**
	 * Constructor
	 * 
	 * @param capacity
	 * @param numPassenger
	 */
	public PassengerVehicleCh04(int capacity, int numPassenger) {
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
	public PassengerVehicleCh04(String userName, int capacity, int numPassenger) {
		super(userName);
		this.capacity = capacity;
		this.numPassenger = numPassenger;
	}

	private int capacity;
	private int numPassenger;
	
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

	public PassengerVehicleCh04(String userName) {
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
	 * @param args
	 */
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		PassengerVehicleCh04 vehicle1 = new PassengerVehicleCh04("aaa", 12, 1);
		
		System.out.println(vehicle1.start());
	}

}
