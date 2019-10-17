/**
 * 
 */
package ex09;

/**
 * @author takahiro watanabe
 *
 */
public abstract class EnergySource {
	private long energyAmount;
	
	public EnergySource(long energyAmount) {
		this.energyAmount = energyAmount;
	}

	public final long getEnergyAmount() {
		return this.energyAmount;
	}
	
	public void setEnergy(long energyAmount) {
		if(energyAmount > 0) {
			this.energyAmount = energyAmount;
		} else {
			this.energyAmount = 0;
		}
	}

	/**
	 * check energy empty
	 * 
	 */
	abstract boolean empty();
}