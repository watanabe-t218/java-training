/**
 * 
 */
package ex11;

/**
 * @author takahiro watanabe
 *�@sort�ς݂̏ꍇ�͂��łɂ������Ԃ��݂̂Ƃ���
 */
abstract class SortDouble2 {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private boolean isSorted = false;

	public final SortMetrics sort(double[] data) {
		
		// sort�ς݂̏ꍇ�͂��łɂ������Ԃ��݂̂Ƃ���
		if(isSorted) {
			return getMetrics();
		}
		
		values = data;
		curMetrics.init();
		doSort();
		isSorted = true;
		return getMetrics();
	}

	public SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength() {
		return values.length;
	}

	protected final double probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		double d1 = values[i];
		double d2 = values[j];
		if (d1 == d2)
			return 0;
		else
			return (d1 < d2 ? -1 : 1);
	}

	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	protected abstract void doSort();
}
