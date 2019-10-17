/**
 * 
 */
package ex09;

/**
 * @author takahiro watanabe
 *
 */
public class Garage implements Cloneable{
	private Vehicle[] vehicles;

	/**
	 * Constructor
	 * @param capacity
	 */
	public Garage(int capacity) {
		vehicles = new Vehicle[capacity];
	}

	public int getCapacity() {
		return vehicles.length;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for(int i = 0; i < this.getCapacity(); i++) {
			str += "[" + i + "]: ";
			if(vehicles[i] != null) {
				str += "full";
			}
			str += "\n";
		}
		
		return str;
	}

	
	/**
	 * @return boolean is full or not
	 */
	public boolean isFull() {
		
		for(int i = 0; i < vehicles.length; i++) {
			if(vehicles[i] == null) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * set vehicle to empty space
	 * @param vehicle
	 * @throws Exception
	 */
	public void setVehicle(Vehicle vehicle) throws Exception {
		if (isFull()) {
			throw new Exception("‹ó‚«‚ª‚ ‚è‚Ü‚¹‚ñ");			
		} else {
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] == null) {
					vehicles[i] = vehicle;
					System.out.println("set to vehicles[" + i + "]\n");
					break;
				}
			}
		}
	}
	
	public void removeVehicle(int garageNum) {
		vehicles[garageNum] = null;
	}

	/**
	 * clone garage but empty
	 */
	public Garage clone() throws CloneNotSupportedException{
		
		try {
			Garage copy = (Garage) super.clone();
			
			// empty garage
			for(int i = 0; i < copy.getCapacity(); i++) {
				copy.removeVehicle(i);
			}
			return copy;
			
		} catch (CloneNotSupportedException e){
			System.out.println(e);
		}
		return null;
		
	}

	public static void main(String[] args) throws Exception {
		Garage garage = new Garage(20);

		// print empty
		System.out.println(garage.toString());
		
		// fulfill
		for(int i = 0; i < garage.getCapacity(); i++) {
			garage.setVehicle(new Vehicle());
		}
		System.out.println(garage.toString());
		
		// test clone -> empty garage sized equals garage
		Garage cloneGarage = garage.clone();
		System.out.println(cloneGarage.toString());
	
	}



}
