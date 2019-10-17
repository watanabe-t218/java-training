/**
 * 
 */
package ex06;

/**
 * @author takahiro watanabe
 *
 */
public class GasTank extends EnergySource {

	public GasTank(long gasAmount) {
		super(gasAmount);
	}

	@Override
	boolean empty() {
		if (getEnergyAmount() == 0) {
			return true;
		}	
		return false;
	}

}
