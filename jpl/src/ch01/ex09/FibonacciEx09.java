package ex09;

/**
 * @author takahiro watanabe
 * console out Fibonacci sequence
 */

public class FibonacciEx09 {
	static final String TITLE = "[Fibonacci]";
	
	static final int INIT_LO = 1;
	static final int INIT_HI = 1;
	static final int LIMIT_NUM = 50;
	static final int LIMIT_INDEX = 100;
	
	/** console out Fibonacci sequence (<50) */
	public static void main(String[] args) {
		int[] fibonacci = new int[LIMIT_INDEX];
		
		fibonacci[0] = INIT_LO;
		fibonacci[1] = INIT_HI;
		
		System.out.println(TITLE);
		
		System.out.println(fibonacci[0]);
		for(int i = 1; fibonacci[i] < LIMIT_NUM; i++) {
			System.out.println(fibonacci[i]);
			fibonacci[i+1] = fibonacci[i] + fibonacci[i-1];
		}
	}
}
