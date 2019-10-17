/**
 *
 */
package ex04;

import java.util.concurrent.TimeUnit;

/**
 * @author takahiro watanabe
 *
 */
public interface BlockingQueue<E> extends Queue<E> {


	/**
	 * 容量制限に違反することなく、指定された要素をこのキューにすぐに挿入できる場合はそうします。成功した場合はtrueを返し、その時点で使用可能な空き領域が存在しない場合はIllegalStateExceptionをスローします。
	 */
	@Override
	boolean add(E e) throws NullPointerException, IllegalStateException;

	/**
	 * 指定された要素がキューに含まれている場合にtrueを返します。つまり、このキューにo.equals(e)となる要素eが1つ以上含まれている場合にだけtrueを返します。
	 */
	@Override
	boolean	contains(Object o)
			throws	ClassCastException,
					NullPointerException;
	
	/**
	 * このキューから利用可能なすべての要素を削除し、それらを指定されたコレクションに追加します。
	 * @param c
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalStateException
	 */
	int drainTo(Collection<? extends E> c) throws NullPointerException, IllegalStateException;

	/**
	 * 指定された数以内の利用可能な要素をこのキューから削除し、指定されたコレクションに追加します。
	 * @param c
	 * @param maxElements
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalStateException
	 */
	int drainTo(Collection<? super E> c, int maxElements) throws NullPointerException, IllegalStateException;

	/**
	 * 指定された要素を、このキューに容量制限に違反することなしにすぐに挿入できる場合には、そうします。成功した場合はtrueを返し、使用可能な空き領域がその時点で存在しない場合はfalseを返します。
	 */
	boolean offer(E o) throws NullPointerException;

	/**
	 * 指定された要素をこのキューに挿入します。必要に応じて、指定された時間まで空きが生じるのを待機します。
	 * @param o
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws NullPointerException
	 */
	boolean offer(E o, long timeout, TimeUnit unit) throws NullPointerException;

	/**
	 * このキューの先頭を取得して削除します。必要に応じて、指定された待機時間まで要素が利用可能になるのを待機します。
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws InterruptedException
	 */
	E poll(long timeout, TimeUnit unit) throws InterruptedException;

	/**
	 * 指定された要素をこのキューに挿入します。必要に応じて、空きが生じるまで待機します。
	 * @param o
	 * @throws InterruptedException
	 */
	void put(E o) throws InterruptedException;

	/**
	 * 理想的な状態(メモリーやリソースの制限がない状態)で、このキューがブロックせずに受け入れることができる追加要素の数を返します。組込み制限が存在しない場合はInteger.MAX_VALUEを返します。
	 * @return
	 */
	int remainingCapacity();
	
	/**
	 * 指定された要素の単一のインスタンスがこのキューに存在する場合は、キューから削除します。
	 * @return
	 */
	boolean remove(Object e)
			throws	ClassCastException,
			NullPointerException;

	/**
	 * このキューの先頭を取得して削除します。必要に応じて、要素が利用可能になるまで待機します。
	 * @return
	 * @throws InterruptedException
	 */
	E take() throws InterruptedException;
}
