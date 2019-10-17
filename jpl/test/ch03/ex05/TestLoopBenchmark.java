/**
 * 
 */
package ex05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author takahiro watanabe
 *
 */
class TestLoopBenchmark {

	@Test
	void testLoopBenchmark() {
		int count = 20;
		int loopNum = 100;
		long time = new LoopBenchmark(loopNum).repeat(count);
		System.out.println(loopNum + "loops in " + time / count + "nanoseconds(ave).");
	}

}
