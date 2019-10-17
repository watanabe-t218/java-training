/**
 * 
 */
package ex12;

/**
 * @author takahiro watanabe
 *@sortÏ‚İ‚Ìê‡‚Í‚·‚Å‚É‚ ‚éî•ñ‚ğ•Ô‚·‚Ì‚İ‚Æ‚·‚é
 */
abstract class SortHarness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private boolean isSorted = false;

	public final SortMetrics sort(Object[] data) {
		
		// sortÏ‚İ‚Ìê‡‚Í‚·‚Å‚É‚ ‚éî•ñ‚ğ•Ô‚·‚Ì‚İ‚Æ‚·‚é
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
	
	protected final Object getValueAt(int i) {
		return values[i];
	}

	protected final int getDataLength() {
		return values.length;
	}

	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	protected final int compare(int i, int j) {
		// compare count is need to do with automatically
		curMetrics.compareCnt++;
		return compareLogic(values[i], values[j]);
	}
	
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	protected abstract void doSort();
	
	// user can make own compare logic
	protected abstract int compareLogic(Object obj1, Object obj2);
}
