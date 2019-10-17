/**
 * 
 */
package ex02;

/**
 * @author takahiro watanabe
 *
 */
public class Y extends X {
	protected int yMask = 0xff00;

	public Y() {
		System.out.printf("[Y1]: %4x \t %4x \t %4x%n", xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("[Y2]: %4x \t %4x \t %4x%n", xMask, yMask, fullMask);
	}

	public static void main(String[] args) {
		System.out.printf("[STS]: xMask\tyMask\tfullMask\n");
		Y y = new Y();
	}
}
