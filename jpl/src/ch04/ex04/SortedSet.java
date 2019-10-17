/**
 *
 */
package ex04;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/**
 * @author takahiro watanabe
 *
 */
public interface SortedSet<E> extends Set<E> {
	/**
	 * このセット内の要素を順序付けするために使うコンパレータを返します。ただし、このセットがその要素の自然順序付けを使う場合はnullを返します。
	 * @return
	 */
	Comparator<? super E> comparator();

	/**
	 * セット内に現在ある最初(下端)の要素を返します。
	 * @return
	 * @throws NoSuchElementException
	 */
	E first() throws NoSuchElementException;

	/**
	 * このセットのtoElementよりも確実に小さい要素を持つ部分のビューを返します。
	 * @param toElement
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	SortedSet<E> headSet(E toElement)
		throws	ClassCastException,
				IllegalArgumentException,
				NullPointerException;

	/**
	 * セット内に現在ある最後(上端)の要素を返します。
	 * @return
	 * @throws NoSuchElementException
	 */
	E last()  throws NoSuchElementException;
	
	/**
	 * このソート・セット内の要素に対するSpliteratorを作成します。
	 * @return(仮)
	 */
	default Spliterator<E>	spliterator() {
		return null;
	}
	
	/**
	 * このセットのfromElement (これを含む) - toElement (これを含まない)の要素範囲を持つ部分のビューを返します。
	 * @param fromElement
	 * @param toElement
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	SortedSet<E> subSet(E fromElement, E toElement)
		throws	ClassCastException,
				IllegalArgumentException,
				NullPointerException;

	/**
	 * このセットのfromElementに等しいかそれよりも大きい要素を持つ部分のビューを返します。
	 * @param fromElement
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	SortedSet<E> tailSet(E fromElement)
		throws	ClassCastException,
				IllegalArgumentException,
				NullPointerException;
}
