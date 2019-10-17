/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public class Battery extends EnergySource{
	
	public Battery(long batteryAmount) {
		super(batteryAmount);
	}

	@Override
	public boolean empty() {
		if (getEnergyAmount() == 0)
			return true;
		return false;
	}

}
