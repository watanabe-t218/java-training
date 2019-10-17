/**
 *
 */
package ex04;

import java.util.NoSuchElementException;

/**
 * @author takahiro watanabe
 * https://docs.oracle.com/javase/jp/8/docs/api/java/util/Queue.html
 */
public interface Queue<E> extends Collection<E> {

	/**
	 * キューの先頭を取得しますが、削除しません。
	 * @return
	 * @throws NoSuchElementException
	 */
	E element() throws NoSuchElementException;

	/**
	 * 容量制限に違反せずにすぐ実行できる場合は、指定された要素をこのキューに挿入します。
	 * @param o
	 * @return
	 */
	boolean offer(E o);

	/**
	 * キューの先頭を取得しますが、削除しません。
	 * @return キューが空の場合はnullを返します。
	 */
	E peek();
	/**
	 * キューの先頭を取得および削除します。キューが空の場合はnullを返します。
	 * @return キューが空の場合はnullを返します。
	 */
	E poll();

	/**
	 * キューの先頭を取得および削除します。
	 * @return
	 * @throws NoSuchElementException
	 */
	E remove() throws NoSuchElementException;
}
