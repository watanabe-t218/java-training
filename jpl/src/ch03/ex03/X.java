/**
 * 
 */
package ex03;

/**
 * @author takahiro watanabe
 *
 */
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X(int yMask) {
		System.out.printf("[X1]: %4x \t %4x \t %4x%n", xMask, 0x0000, fullMask);
		fullMask = xMask | yMask;
		System.out.printf("[X2]: %4x \t %4x \t %4x%n", xMask, 0x0000, fullMask);
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

}