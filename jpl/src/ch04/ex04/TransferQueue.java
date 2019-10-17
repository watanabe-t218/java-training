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
	 * BlockingQueue.take()�܂��͎��Ԏw���poll�o�R�ŗv�f���󂯎�邱�Ƃ�ҋ@���Ă���R���V���[�}�̐��萔��Ԃ��܂��B
	 * @return
	 */
	int	getWaitingConsumerCount();
	
	/**
	 * BlockingQueue.take()�܂��͎��Ԏw���poll�o�R�ŗv�f���󂯎�邱�Ƃ�ҋ@���Ă���R���V���[�}�����Ȃ��Ƃ�1����ꍇ�Atrue��Ԃ��܂��B
	 * @return
	 */
	boolean	hasWaitingConsumer();

	/**
	 * �ҋ@����K�v������Αҋ@���A�v�f���R���V���[�}�ɓ]�����܂��B
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
	 * �^�C���E�A�E�g���o�߂���O�ɗv�f���R���V���[�}�ɓ]���ł���ꍇ�ɂ́A�������܂�
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
	 * �\�ȏꍇ�A�ҋ@���̃R���V���[�}�ɗv�f���������ɓ]�����܂��B
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
