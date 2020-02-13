/**
 * 
 */
package ex01;

/**
 * @author watanabe
 *
 */
public class LinkedList<E> implements Cloneable {
	
	private Node head;
	private Node tail;
	
	public Node<E> getHead() {
		return head;
	}
	
	public Node<E> getTail() {
		return tail;
	}
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(E item) {
		if(head == null) {
			this.head = new Node<E>(item);
			this.tail = this.head;
		} else {
			this.tail.next = new Node<E>(item);
			this.tail = this.tail.next;
		}
	}
	
	
	public Node<E> getNode(int index) {
		if(head == null) {
			return null;
		} else {
			Node<E> node = this.head;
			int i = 0;
			while(node != null) {
				if(i == index) {
					return node;
				}
				node = node.next;
				i++;
			}
			return null;
		}
	}
	
	public int size() {
		int size = 0;
		Node<E> node = this.head;
		while(node != null) {
			size++;
			node = node.next;
		}
		return size;
	}
	
	public LinkedList<E> clone() {
		
		Node<E> node = new Node(this.head.item);
		LinkedList<E> linkedList = new LinkedList<E>();
		
		while(node != null) {
			linkedList.add(node.item);
			node = node.next;
		}
		
		return linkedList;
	}
	
	public String toString() {
		if(this.head == null) {
			return null;
		} else {
			String str = this.head.toString();
			Node<E> node = this.head.next;
			while(node != null) {
				str += "\n" + node.toString();
				node = node.next;
			}
			return str;
		}
	}
	
	
	class Node<E> {


		private E item;
		private Node<E> next;
		
		public void setItem(E item) {
			this.item = item;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
		
		public E getItem() {
			return item;
		}
		
		public Node<E> getNext() {
			return next;
		}

		public Node(E item) {
			this.item = item;
			this.next = null;
		}
		
		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
		
		public String toString() {
			return this.item.toString();
		}
	}		
	
}
