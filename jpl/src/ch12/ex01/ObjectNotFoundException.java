/**
 * 
 */
package ex01;

/**
 * @author watanabe
 *
 */
public class ObjectNotFoundException extends Exception {
	public Object item;
	
	public ObjectNotFoundException(Object item) {
		super("No such item \"" +item.toString()+ "\"");
		this.item = item;
	}
}
