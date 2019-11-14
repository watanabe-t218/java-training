/**
 * 
 */
package ex03;

/**
 * @author Watari-Home
 *
 */
public class WorkDay {
	public Boolean isWorkDay(EnumDays day){
		switch (day) {
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			return true;
		}
	}
}
