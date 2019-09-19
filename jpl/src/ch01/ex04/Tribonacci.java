package ex04;

/**
 * @author takahiro watanabe
 *
 */
public class Tribonacci {

	/** console out Tribonacci sequence (<50) */
	public static void main(String[] args) {
		String title = "Tribonacci";
		
		// Init Parameters
		int lo = 0;
		int mi = 0;
		int hi = 1;
		
		System.out.println("[" + title + "]");
		
		System.out.println(lo);
		System.out.println(mi);
		while (hi < 50) {
			System.out.println(hi);
			hi = lo + mi + hi;
			mi = hi - mi - lo;
			lo = hi - mi - lo;
		}
	}

}
