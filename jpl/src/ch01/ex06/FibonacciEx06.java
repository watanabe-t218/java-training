package ex06;

/**
 * @author takahiro watanabe
 * console out Fibonacci sequence
 */

public class FibonacciEx06 {
	static final String TITLE = "[Fibonacci]";
	
	static final int INIT_LO = 1;
	static final int INIT_HI = 1;
	static final int LIMIT_NUM = 50;
	
	/** console out Fibonacci sequence (<50) */
	public static void main(String[] args) {

		int lo = INIT_LO;
		int hi = INIT_HI;
		
		System.out.println(TITLE);
		
		System.out.println(lo);
		while (hi < LIMIT_NUM) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
