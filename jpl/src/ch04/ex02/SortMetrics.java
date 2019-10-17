/**
 * 
 */
package ex02;

/**
 * @author takahiro watanabe
 *
 */
public class SortMetrics implements Cloneable {
	public long probeCnt,
				compareCnt,
				swapCnt;

	public void init() {
		probeCnt = compareCnt = swapCnt = 0;
	}

	public String toString() {
		return probeCnt + " probes " +
			   compareCnt + " compares " +
			   swapCnt + " swaps";
	}

	public SortMetrics clone() {
		try {
			return (SortMetrics) super.clone();
		} catch(CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

}