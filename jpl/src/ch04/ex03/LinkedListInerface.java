/**
 *
 */
package ex03;

/**
 * @author takahiro watanabe
 */
public interface LinkedListInerface {

	/**
	 * get list size
	 * @return size
	 */
	int size();

	/**
	 * add node to last
	 * @param value
	 */
	void add(Object value);

	/**
	 * get value of node
	 * @param index
	 * @return value
	 */
	Object get(int index);

	/**
	 * @param index
	 * @param value
	 * @return oldValue
	 */
	Object set(int index, Object value);

	/**
	 * @param value
	 * @return true or false
	 */
	boolean contains(Object value);

}