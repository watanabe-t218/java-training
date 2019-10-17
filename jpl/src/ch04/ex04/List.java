/**
 *
 */
package ex04;

import java.util.ListIterator;

/**
 * @author takahiro watanabe
 * https://docs.oracle.com/javase/jp/8/docs/api/java/util/List.html
 */
public interface List<E> extends Collection<E> {
	/**
	 * 指定された要素をこのリストの最後に追加します(オプションの操作)。
	 * @param index
	 * @param element
	 */
	void add(int index, E element)
		throws	UnsupportedOperationException,
				ClassCastException,
				NullPointerException,
				IllegalArgumentException,
				IndexOutOfBoundsException;

	/**
	 * 指定されたコレクション内のすべての要素を、指定されたコレクションのイテレータによって返される順序で、このリストの最後に追加します(オプションの操作)。
	 * @param index
	 * @param c
	 * @return
	 */
	boolean addAll(int index, Collection<? extends E> c)
		throws	UnsupportedOperationException,
				ClassCastException,
				NullPointerException,
				IllegalArgumentException,
				IndexOutOfBoundsException;

	/**
	 * このリスト内の指定された位置にある要素を返します。
	 * @param index
	 * @return
	 */
	E get(int index) throws IndexOutOfBoundsException;

	/**
	 * 指定された要素がこのリスト内で最初に検出された位置のインデックスを返します。指定された要素がこのリストにない場合は -1を返します。
	 * @param o
	 * @return
	 */
	int indexOf(Object o) throws ClassCastException, NullPointerException;

	/**
	 * 指定された要素がこのリスト内で最後に検出された位置のインデックスを返します。指定された要素がこのリストにない場合は -1を返します。
	 * @param o
	 * @return
	 */
	int lastIndexOf(Object o) throws ClassCastException, NullPointerException;

	/**
	 * このリスト内の要素を(適切な順序で)反復するリスト・イテレータを返します。
	 * @return
	 */
	ListIterator<E> listIterator();

	/**
	 * リスト内の指定された位置で始まる、リスト内の要素を(適切な順序で)反復するリスト・イテレータを返します。
	 * @param index
	 * @return
	 */
	ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException;

	/**
	 * このリスト内の指定された位置にある要素を削除します(オプションの操作)。
	 * @param index
	 * @return
	 */
	E remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException;

	/**
	 * このリスト内の指定された位置にある要素を、指定された要素に置き換えます(オプションの操作)。
	 * @param index
	 * @param element
	 * @return
	 */
	E set(int index, E element)
		throws	UnsupportedOperationException,
				ClassCastException,
				NullPointerException,
				IllegalArgumentException,
				IndexOutOfBoundsException;

	/**
	 * このリストの、指定されたfromIndex (これを含む)からtoIndex (これを含まない)までの部分のビューを返します。
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	List<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException;
}
