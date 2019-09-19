package ex15;

/**
 * @author takahiro watanabe
 *
 */
public interface ImprovedLookup<T> extends Lookup<Object>{
	/** add name to list in class*/
	void add(String name, T value);
	
	/** remove name from list in class if exists*/
	T remove(T name);
}
