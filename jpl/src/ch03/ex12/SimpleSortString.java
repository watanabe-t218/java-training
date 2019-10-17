/**
 * 
 */
package ex12;

/**
 * @author Watari-Home
 *
 */
public class SimpleSortString extends SortHarness{
	
	@Override
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j ++) {
				if(compare(i, j) > 0) {
					swap(i, j);
				}
			}
		}
	}

	/**
	 * user compare logic 
	 * alphabet sort 
	 */
	@Override
	protected int compareLogic(Object obj1, Object obj2) {
		String str1 = (String)obj1;
		String str2 = (String)obj2;
		return str1.compareTo(str2);
	}
}
