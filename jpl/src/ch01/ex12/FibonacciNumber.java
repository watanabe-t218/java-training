package ex12;

/**
 * @author takahiro watanabe
 * Fibonacci number and utility
 */
public class FibonacciNumber {
	public int num;
	public boolean isEven;
	
	// Set num & isEven
	public FibonacciNumber(int num) {
		this.num = num;
		if(this.num % 2 == 0) {
			this.isEven = true;
		}
		else {
			this.isEven = false;
		}
	}
}
