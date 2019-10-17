package ex04;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * https://docs.oracle.com/javase/jp/8/docs/api/java/util/Collection.html
 */

public interface Collection<E> {
	/**
	 * 指定された要素がこのコレクションに格納されていることを保証します(オプションの操作)。
	 * @param e
	 * @return
	 */
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
	boolean addAll(Collection<? extends E> c)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * このコレクションからすべての要素を削除します(オプションの操作)。
	 */
	void clear() throws UnsupportedOperationException;

	/**
	 * 指定された要素がコレクションに含まれている場合にtrueを返します。
	 * @param o
	 * @return
	 */
	boolean contains(Object o) throws ClassCastException, NullPointerException;

	/**
	 * 指定されたコレクションのすべての要素がこのコレクション内にある場合はtrueを返します。
	 * @param c
	 * @return
	 */
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
	boolean isEmpty();

	/**
	 * コレクションの要素のイテレータを返します。
	 * @return
	 */
	Iterator<E> iterator();

	/**
	 * このコレクションをソースとして、潜在的に並列のStreamを返します。
	 * @return(仮)
	 */
	default Stream<E> parallelStream() {
		return null;
	}
	
	/**
	 * 指定された要素のインスタンスがこのコレクションにあれば、そのインスタンスをコレクションから1つ削除します(オプションの操作)。
	 * @param o
	 * @return
	 */
	boolean remove(Object o)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * 指定されたコレクションにも格納されているこのコレクションのすべての要素を削除します(オプションの操作)。
	 * @param c
	 * @return
	 */
	boolean removeAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * このコレクションにおいて、指定されたコレクションに格納されている要素だけを保持します(オプションの操作)。
	 * @param c
	 * @return
	 */
	boolean retainAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;


	/**
	 * このコレクション中の要素の数を返します。
	 * @return
	 */
	int size();
	
	/**
	 * このコレクション内の要素に対するSpliteratorを作成します。
	 * @return (仮)
	 */
	default Spliterator<E>	spliterator() {
		return null;
	}

	/**
	 * このコレクションをソースとして使用して、逐次的なStreamを返します。
	 * @return (仮)
	 */
	default Stream<E> stream(){
		return null;
	}
	
	/**
	 * このコレクションの要素がすべて格納されている配列を返します。
	 * @return
	 */
	Object[] toArray();

	/**
	 * このコレクション内のすべての要素を保持する配列を返します。返される配列の実行時の型は、指定された配列の型です。
	 * @param a
	 * @return
	 */
	<T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException;


}