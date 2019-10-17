/**
 * 
 */
package ex04;

import java.util.concurrent.TimeUnit;

/**
 * @author Watari-Home
 * @param <E>
 *
 */
public interface TransferQueue<E> extends Collection<E>{
	
	/**
	 * BlockingQueue.take()または時間指定のpoll経由で要素を受け取ることを待機しているコンシューマの推定数を返します。
	 * @return
	 */
	int	getWaitingConsumerCount();
	
	/**
	 * BlockingQueue.take()または時間指定のpoll経由で要素を受け取ることを待機しているコンシューマが少なくとも1つある場合、trueを返します。
	 * @return
	 */
	boolean	hasWaitingConsumer();

	/**
	 * 待機する必要があれば待機し、要素をコンシューマに転送します。
	 * @param e
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 * @throws InterruptedException
	 */
	void	transfer(E e)
			throws	ClassCastException,
					IllegalArgumentException,
					NullPointerException,
					InterruptedException;
	
	/**
	 * タイム・アウトが経過する前に要素をコンシューマに転送できる場合には、そうします
	 * @param e
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 * @throws InterruptedException
	 */
	boolean	tryTransfer(E e)
			throws	ClassCastException,
					IllegalArgumentException,
					NullPointerException,
					InterruptedException;
	
	/**
	 * 可能な場合、待機中のコンシューマに要素をただちに転送します。
	 * @param e
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	boolean	tryTransfer(E e, long timeout, TimeUnit unit)
			throws	ClassCastException,
					IllegalArgumentException,
					NullPointerException;
}
