package ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayListStack<E> {
	private final List<E> stack = new ArrayList<E>();
	
	public E push(E e) {
		stack.add(0, e);
		return e;
	}
	
	public E pop() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		return stack.remove(0);
	}
	
	public E peek() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		return stack.get(0);
	}
	
	public boolean empty() {
		return stack.isEmpty();
	}
	
	public int search(E e) {
		int index = stack.indexOf(e);
		if (index != -1)
			return index + 1;
		return index;
	}
	
}
