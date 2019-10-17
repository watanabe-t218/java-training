/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public abstract class EnergySource implements Empty{
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

}