package ex03;

/**
 * @author takahiro watanabe
 * console out Fibonacci sequence
 */
public class Fibonacci {

	/** console out Fibonacci sequence (<50) */
	public static void main(String[] args) {
		String title = "Fibonacci";
		
		// Init Parameters
		int lo = 1;
		int hi = 1;
		
		System.out.println("[" + title + "]");
		
		System.out.println(lo);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
