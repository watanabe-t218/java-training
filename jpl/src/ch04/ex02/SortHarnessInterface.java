/**
 * 
 */
package ex02;

/**
 * @author Watari-Home
 *
 */
public interface SortHarnessInterface {

	// sortLogic(scan, compare, swap)
	public void doSort();
	
	// user can make own compare logic
	public int compareLogic(Object obj1, Object obj2);
}
