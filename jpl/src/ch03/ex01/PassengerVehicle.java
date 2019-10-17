/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public class PassengerVehicle extends Vehicle{

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

	public PassengerVehicle(String userName) {
		super(userName);
	}
	
	public String seatStatus() {	
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
		
		PassengerVehicle vehicle1 = new PassengerVehicle("aaa", 12, 1);
		PassengerVehicle vehicle2 = new PassengerVehicle("bbb", 34, 12);
		System.out.println(vehicle1.seatStatus());
		System.out.println(vehicle2.seatStatus());
	}

}
