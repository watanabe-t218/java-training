/**
 * 
 */
package ex04;

/**
 * @author Watari-Home
 *
 */
public enum EnumTrafficLight {
	RED (new Color("red")), 
	Yellow (new Color("yellow")), 
	Blue (new Color("blue"));
	
	Color color;
	EnumTrafficLight(Color color) {
		this.color = color;
	}
	
	public String toString( ) {
		return color.getColorName();
	}
}