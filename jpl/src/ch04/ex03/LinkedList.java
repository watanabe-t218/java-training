/**
 *
 */
package ex03;

/**
 * @author takahiro watanabe
 * 
 */
public class LinkedList implements Cloneable, LinkedListInerface {
	private Node header;

	public LinkedList() {
		header = null;
	}

	/**
	 * @param value
	 */
	public LinkedList(Object value) {
		add(value);
	}

	/**
	 * @return value
	 */
	public Object getHeader() {
		if (header == null)
			return null;
		else
			return header.value;
	}

	/**
	 * @return tailNode
	 */
	protected Node getTailNode() {
		if (header == null)
			return null;
		else {
			Node node = header;
			while(node.next != null)
				node = node.next;
			return node;
		}
	}

	/**
	 * get value of Tail node
	 * @return value
	 */
	public Object getTail() {
		Node tailNode = getTailNode();
		if (tailNode == null)
			return null;
		else
			return tailNode.value;
	}


	@Override
	public int size() {
		if (header == null)
			return 0;
		else {
			Node node = header;
			int size = 1;
			while(node.next != null) {
				size++;
				node = node.next;
			}
			return size;
		}
	}
	
	@Override
	public void add(Object value) {
		if (value == null)
			throw new IllegalArgumentException("null");
		else {
			Node tailNode = getTailNode();
			if (tailNode == null)
				header = new Node(value);
			else
				tailNode.next = new Node(value);
		}
	}

	/**
	 * get value of index node 
	 * @param index
	 * @return Node
	 */
	protected Node getNode(int index) {
		if (header == null)
			return null;
		else if (index == 0)
			return header;
		else {
			Node node = header;
			int i = 0;
			while (node != null) {
				if (i == index)
					return node;
				i++;
				node = node.next;
			}
			return null;
		}
	}

	@Override
	public Object get(int index) {
		Node node = getNode(index);
		if (node == null)
			return null;
		else
			return node.value;
	}

	@Override
	public Object set(int index, Object value) {
		Node node = getNode(index);
		if (node == null)
			return null;
		else if (value == null)
			throw new IllegalArgumentException("null");
		else {
			Object oldValue = node.value;
			node.value = value;
			return oldValue;
		}
	}

	@Override
	public boolean contains(Object value) {
		if (header == null)
			return false;
		else {
			Node node = header;
			while (node != null) {
				if (node.value.equals(value))
					return true;
				node = node.next;
			}
			return false;
		}
	}

	/**
	 * Clone
	 */
	public LinkedList clone() {
		try {
			LinkedList list = (LinkedList) super.clone();
			if (list.header == null)
				return list;
			else {
				Node sourceNode = header;
				Node node = sourceNode.clone();
				list.header = node;
				while (sourceNode.next != null) {
					node.next = sourceNode.next.clone();
					node = node.next;
					sourceNode = sourceNode.next;
				}
				return list;
			}
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	@Override
	public String toString() {
		if (header == null)
			return "empty";
		else {
			String desc = "header: " + header + "\n";
			Node node = header.next;
			while (node != null) {
				desc += "-> " + node + "\n";
				node = node.next;
			}
			return desc;
		}
	}

	class Node implements Cloneable {
		private Object value;
		private Node next;

		/**
		 * @param value
		 */
		Node(Object value) {
			this(value, null);
		}

		/**
		 * @param value
		 * @param next
		 */
		Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return value.toString();
		}

		public Node clone() {
			try {
				Node node =  (Node) super.clone();
				if (node.next != null)
					node.next = null;
				return node;
			} catch (CloneNotSupportedException e) {
				throw new InternalError(e.toString());
			}
		}
	}
}
