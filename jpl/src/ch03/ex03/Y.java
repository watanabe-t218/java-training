/**
 * 
 */
package ex03;

/**
 * @author takahiro watanabe
 *
 */
public class Y extends X {
	protected int yMask;

	public Y(int yMask) {
		super(yMask);
		this.yMask = yMask;
//		System.out.printf("[Y1]: %4x \t %4x \t %4x%n", xMask, yMask, fullMask);
		System.out.printf("[Y2]: %4x \t %4x \t %4x%n", xMask, yMask, fullMask);
	}

	public static void main(String[] args) {
		int yMask = 0xff00;
		
		System.out.printf("[STS]: xMask\tyMask\tfullMask\n");
		Y y = new Y(yMask);
	}
}
