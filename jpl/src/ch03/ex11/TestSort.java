/**
 * 
 */
package ex11;

/**
 * @author Watari-Home
 *
 */
public class TestSort {
	static double[] testData = {
			0.3, 1.3e-2, 7.9, 3.17
	};
	
	public static void main(String[] args) {
		SortDouble2 bsort = new SimpleSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		
		// ここから不正部分
		double[] easyTestData = {
				0, 1, 2, 3
		};
		metrics = bsort.sort(easyTestData);
		// ここまで不正部分
		
		System.out.println("Metrics: " + metrics); // swap回数が０と表示される
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}
