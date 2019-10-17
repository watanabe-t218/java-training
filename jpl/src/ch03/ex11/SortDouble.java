/**
 * 
 */
package ex11;

/**
 * @author takahiro watanabe
 *
 *�@�Z�L�����e�B�z�[��
 * public����SortMetrics�C���X�^���X�̏������������ĂԂ��Ƃ��ł���̂ŁC�\�[�g��ł�SortMetrics���̏������ςł���
 */
abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(double[] data) {
		values = data;
		curMetrics.init(); //public����SortMetrics�C���X�^���X�̏������������ĂԂ��Ƃ��ł���̂ŁC�\�[�g�r���ł�SortMetrics���̏������ςł���
		doSort();
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
