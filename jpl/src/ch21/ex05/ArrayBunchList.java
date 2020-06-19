package ex05;

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayBunchList<E> extends AbstractList<E> {
	private final E[][] arrays;
	private final int size;
	
	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays;
		int s = 0;
		for (E[] array: arrays)
			s += array.length;
		size = s;
	}
	
	@Override
	public E get(int index) {
		int off = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length)
				return arrays[i][index - off];
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public E set(int index, E value) {
		int off = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length) {
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	
	
	@Override
	public ListIterator<E> listIterator() {
		return new ABLListIterator();
	}
	
	protected class ABLListIterator implements ListIterator<E> {

		private int off;
		private int array; 
		private int pos;
		
		private boolean canSet;
		
		ABLListIterator() {
			off = 0;
			array = 0;
			pos = 0;
			canSet = false;
			for (array = 0; array < arrays.length; array++)
				if (arrays[array].length > 0)
					break;
		}
		/**
		 * hasNext
		 */
		@Override
		public boolean hasNext() {
			return (off + pos) < size();
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			if (!hasPrevious()) {
				array = 0;
				off = 0;
			}
			
			E ret = arrays[array][pos++];
			
			while (pos >= arrays[array].length) {
				off += arrays[array++].length;
				pos = 0;
				if (array >= arrays.length) 
					break;
			}
			canSet = true;
			System.out.printf("[Next] array: %d, pos: %d, off: %d%n", array, pos, off);
			return ret;
		}

		@Override
		public boolean hasPrevious() {
			return (pos + off) > 0;
		}

		@Override
		public E previous() {
			if (!hasPrevious())
				throw new NoSuchElementException();
			
			if (!hasNext()) {
				off -= arrays[--array].length;
				pos = arrays[array].length;
			}
			
			E ret = arrays[array][--pos];
			System.out.printf("[Previous1] array: %d, pos: %d, off: %d%n", array, pos, off);
			
			while (pos <= 0) {
				off -= arrays[array--].length;
				if (array <  0)
					break;
				pos = arrays[array].length;	
			}
			canSet = true;
			System.out.printf("[Previous2] array: %d, pos: %d, off: %d%n", array, pos, off);
			return ret;
		}

		@Override
		public int nextIndex() {
			return off + pos + 1;
		}

		@Override
		public int previousIndex() {
			return off + pos - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(E e) {
			if (!canSet)
				throw new IllegalStateException("previous/next is not called.");
			arrays[array][pos] = e;
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException("do not add.");
		}
		
	}
	

}
