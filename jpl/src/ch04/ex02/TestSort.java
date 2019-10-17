/**
 * 
 */
package ex02;

/**
 * @author Watari-Home
 *
 */
public class TestSort {
	static String[] testData = {
			"ee", "bb", "aa", "dd", "cc"
	};
	
	public static void main(String[] args) {
		SortHarness sort = new SimpleSortString();
		SortMetrics metrics = sort.sort(testData);
		
		System.out.println("Metrics: " + metrics); 
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}
