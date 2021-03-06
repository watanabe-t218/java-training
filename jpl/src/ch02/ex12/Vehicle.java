package ex12;

/**
 * @author takahiro watanabe
 * 
 * 	現状不要．
 * 	構成するパーツ等のデータや，
 * 	乗員データ等を用いるような場合，
 * 	可変長引数が必要と考えられる．
 *
 */
public class Vehicle {
	private final long id;	// ID has to be exist & immutable
	static long nextId = 0;
	
	public String userName;
	public double velocity;
	public double[] direction;
	
	public Vehicle() {
		this.id = this.nextId++;
	}
	
	public Vehicle(String userName) {
		this.id = this.nextId++;
		this.userName = userName;
	}
	
	public void showData() {
		System.out.println(
				"ID: \t" 		+ this.id + "\n" + 
				"User: \t" 		+ this.userName + "\n" +
				"Velocity: \t" 	+ this.velocity + "\n" +
				"Direction: \t{ " + this.direction[0] + ", "
								  + this.direction[1] + ", "
								  + this.direction[2] + " }\n");
	}
	
	static long getMaxId() {
		return nextId - 1;
	}
	
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
}
