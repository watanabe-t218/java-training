/**
 * 
 */
package ex08;

/**
 * @author takahiro watanabe
 *
 */
public class Battery extends EnergySource{
	
	public Battery(long batteryAmount) {
		super(batteryAmount);
	}

	@Override
	boolean empty() {
		if (getEnergyAmount() == 0)
			return true;
		return false;
	}

}
