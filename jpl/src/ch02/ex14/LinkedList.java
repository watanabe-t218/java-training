package ex14;

/**
 * @author Watari-Home
 *
 */
public class LinkedList {
	private Object data;		// {get; set;}: for Set data, Browse data
	private LinkedList next;	// {get; set;}: can get&change next chain
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

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
	 * @param data
	 */
	public LinkedList(Object data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * generate with data & next list object
	 * @param data
	 * @param next
	 */
	public LinkedList(Object data, LinkedList next) {
		this.data = data;
		this.next = next;
	}
}
