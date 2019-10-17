/**
 * 
 */
package ex05;

/**
 * @author takahiro watanabe
 *
 */
public class LoopBenchmark extends Benchmark {
	
	private static int loopNum;
	
	public LoopBenchmark(int loopNum) {
		if(loopNum > 0) {
			this.loopNum = loopNum;			
		}
		else {
			this.loopNum = 1;
		}
	}
	
	/**
	 * loop for loopNum
	 */
	@Override
	void benchmark() {
		for (int i = 0; i < this.loopNum; i++) {
		}
	}
	
	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		// loop (loop for loopNum) for count
		long time = new LoopBenchmark(Integer.parseInt(args[1])).repeat(count);
		System.out.println(loopNum + "loops in " + time / count + "nanoseconds(ave).");
	}
}
