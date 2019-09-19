package ex08;

/**
 * @author Watari-Home
 *
 */
public class LinkedList {
	public Object data;
	public LinkedList next;
	
	/**
	 * generate null list object (for start point)
	 * 
	 * */
	public LinkedList() {
		this.data = null;
		this.next = null;
	}
	
	/**
	 * generate with data 
	 * 
	 * */
	public LinkedList(Object data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * generate with data & next list object
	 * 
	 * */
	public LinkedList(Object data, LinkedList next) {
		this.data = data;
		this.next = next;
	}
}
