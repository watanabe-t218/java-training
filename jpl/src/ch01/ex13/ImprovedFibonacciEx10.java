package ex13;

/**
 * @author takahiro watanabe
 *
 */
public class ImprovedFibonacciEx10 {

	static final int MAX_INDEX = 9;
	
	/** console out Fibonacci Sequence format([INDEX]: [NUM] [isEven])*/
	public static void main(String[] args) {
		
		FibonacciNumber[] fibonacci = new FibonacciNumber[MAX_INDEX];
		fibonacci[0] = new FibonacciNumber(1);
		fibonacci[1] = new FibonacciNumber(1);
		
		for (int i = 0; i < MAX_INDEX; i++) {
			if (i >= 2) {
				fibonacci[i] = new FibonacciNumber(fibonacci[i-1].num + fibonacci[i-2].num);		
			}
			System.out.printf("%d: %d %s%n", (i+1), fibonacci[i].num, (fibonacci[i].isEven? "*": ""));
		}
	}

}
