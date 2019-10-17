/**
 *
 */
package ex04;

import java.util.Iterator;

/**
 * @author takahiro watanabe
 *
 */
public interface Set<E> extends Collection<E> {
	/**
	 * 指定された要素がこのコレクションに格納されていることを保証します(オプションの操作)。
	 * @param e
	 * @return
	 */
	@Override
	boolean add(E e)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * 指定されたコレクションのすべての要素をこのコレクションに追加します(オプションの操作)。
	 * @param c
	 * @return
	 */
	@Override
	boolean addAll(Collection<? extends E> c)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * このコレクションからすべての要素を削除します(オプションの操作)。
	 */
	@Override
	void clear() throws UnsupportedOperationException;

	/**
	 * 指定された要素がコレクションに含まれている場合にtrueを返します。
	 * @param o
	 * @return
	 */
	@Override
	boolean contains(Object o) throws ClassCastException, NullPointerException;

	/**
	 * 指定されたコレクションのすべての要素がこのコレクション内にある場合はtrueを返します。
	 * @param c
	 * @return
	 */
	@Override
	boolean containsAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException;

	/**
	 * 指定されたオブジェクトとこのコレクションが等しいかどうかを比較します。
	 * @param o
	 * @return
	 */
	@Override
	boolean equals(Object o);

	/**
	 * コレクションのハッシュ・コード値を返します。
	 * @return
	 */
	@Override
	int hashCode();

	/**
	 * このコレクションに要素がない場合にtrueを返します。
	 * @return
	 */
	@Override
	boolean isEmpty();

	/**
	 * コレクションの要素のイテレータを返します。
	 * @return
	 */
	@Override
	Iterator<E> iterator();

	/**
	 * 指定された要素のインスタンスがこのコレクションにあれば、そのインスタンスをコレクションから1つ削除します(オプションの操作)。
	 * @param o
	 * @return
	 */
	@Override
	boolean remove(Object o)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * 指定されたコレクションにも格納されているこのコレクションのすべての要素を削除します(オプションの操作)。
	 * @param c
	 * @return
	 */
	@Override
	boolean removeAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * このコレクションにおいて、指定されたコレクションに格納されている要素だけを保持します(オプションの操作)。
	 * @param c
	 * @return
	 */
	@Override
	boolean retainAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;


	/**
	 * このコレクション中の要素の数を返します。
	 * @return
	 */
	@Override
	int size();

	/**
	 * このコレクションの要素がすべて格納されている配列を返します。
	 * @return
	 */
	@Override
	Object[] toArray();

	/**
	 * このコレクション内のすべての要素を保持する配列を返します。返される配列の実行時の型は、指定された配列の型です。
	 * @param a
	 * @return
	 */
	@Override
	<T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException;
}
