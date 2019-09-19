package ex15;

/**
 * @author takahiro watanabe
 *
 */
public interface Lookup<T> {
	/** return value related to "name" or
	 * return "null" if not exists such value 
	 */
	T find(String name);
}
