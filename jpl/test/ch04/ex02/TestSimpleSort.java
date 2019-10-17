package ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleSort {

	@Test
	void testSimpleSort() {
		
		// sort
		String[] testData = {
				"ee", "bb", "aa", "dd", "cc"
		};
			
		SortHarness sort = new SimpleSortString();
		SortMetrics metrics = sort.sort(testData);
			
		System.out.println("Metrics: " + metrics); 
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
		
		
		// compare with expected sort data
		String[] sortedData = {
				"aa", "bb", "cc", "dd", "ee"
		};
		for(int i = 0; i < testData.length; i++) {			
			assertEquals(sortedData[i], testData[i]);
		}
	}
}


