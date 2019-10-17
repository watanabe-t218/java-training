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
		
		// ‚±‚±‚©‚ç•s³•”•ª
		double[] easyTestData = {
				0, 1, 2, 3
		};
		metrics = bsort.sort(easyTestData);
		// ‚±‚±‚Ü‚Å•s³•”•ª
		
		System.out.println("Metrics: " + metrics); // swap‰ñ”‚ª‚O‚Æ•\¦‚³‚ê‚é
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}
