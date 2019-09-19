package ex12;

/**
 * @author Watari-Home
 *
 *	連結リストの単一オブジェクトのため，Vehicleを保持する際には可変長引数は不要
 *	Vehicleの分類をした場合 
 *	分類A:[vehicle1, vehicle2], 
 *	分類B:[vehicle1, vehicle2, vehicle2]
 *	などをリストとして持つ場合可変長引数が必要になると考えられる．
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
