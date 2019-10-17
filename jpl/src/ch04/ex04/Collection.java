package ex04;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * https://docs.oracle.com/javase/jp/8/docs/api/java/util/Collection.html
 */

public interface Collection<E> {
	/**
	 * �w�肳�ꂽ�v�f�����̃R���N�V�����Ɋi�[����Ă��邱�Ƃ�ۏ؂��܂�(�I�v�V�����̑���)�B
	 * @param e
	 * @return
	 */
	boolean add(E e)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * �w�肳�ꂽ�R���N�V�����̂��ׂĂ̗v�f�����̃R���N�V�����ɒǉ����܂�(�I�v�V�����̑���)�B
	 * @param c
	 * @return
	 */
	boolean addAll(Collection<? extends E> c)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * ���̃R���N�V�������炷�ׂĂ̗v�f���폜���܂�(�I�v�V�����̑���)�B
	 */
	void clear() throws UnsupportedOperationException;

	/**
	 * �w�肳�ꂽ�v�f���R���N�V�����Ɋ܂܂�Ă���ꍇ��true��Ԃ��܂��B
	 * @param o
	 * @return
	 */
	boolean contains(Object o) throws ClassCastException, NullPointerException;

	/**
	 * �w�肳�ꂽ�R���N�V�����̂��ׂĂ̗v�f�����̃R���N�V�������ɂ���ꍇ��true��Ԃ��܂��B
	 * @param c
	 * @return
	 */
	boolean containsAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException;

	/**
	 * �w�肳�ꂽ�I�u�W�F�N�g�Ƃ��̃R���N�V���������������ǂ������r���܂��B
	 * @param o
	 * @return
	 */
	@Override
	boolean equals(Object o);

	/**
	 * �R���N�V�����̃n�b�V���E�R�[�h�l��Ԃ��܂��B
	 * @return
	 */
	@Override
	int hashCode();

	/**
	 * ���̃R���N�V�����ɗv�f���Ȃ��ꍇ��true��Ԃ��܂��B
	 * @return
	 */
	boolean isEmpty();

	/**
	 * �R���N�V�����̗v�f�̃C�e���[�^��Ԃ��܂��B
	 * @return
	 */
	Iterator<E> iterator();

	/**
	 * ���̃R���N�V�������\�[�X�Ƃ��āA���ݓI�ɕ����Stream��Ԃ��܂��B
	 * @return(��)
	 */
	default Stream<E> parallelStream() {
		return null;
	}
	
	/**
	 * �w�肳�ꂽ�v�f�̃C���X�^���X�����̃R���N�V�����ɂ���΁A���̃C���X�^���X���R���N�V��������1�폜���܂�(�I�v�V�����̑���)�B
	 * @param o
	 * @return
	 */
	boolean remove(Object o)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * �w�肳�ꂽ�R���N�V�����ɂ��i�[����Ă��邱�̃R���N�V�����̂��ׂĂ̗v�f���폜���܂�(�I�v�V�����̑���)�B
	 * @param c
	 * @return
	 */
	boolean removeAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * ���̃R���N�V�����ɂ����āA�w�肳�ꂽ�R���N�V�����Ɋi�[����Ă���v�f������ێ����܂�(�I�v�V�����̑���)�B
	 * @param c
	 * @return
	 */
	boolean retainAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;


	/**
	 * ���̃R���N�V�������̗v�f�̐���Ԃ��܂��B
	 * @return
	 */
	int size();
	
	/**
	 * ���̃R���N�V�������̗v�f�ɑ΂���Spliterator���쐬���܂��B
	 * @return (��)
	 */
	default Spliterator<E>	spliterator() {
		return null;
	}

	/**
	 * ���̃R���N�V�������\�[�X�Ƃ��Ďg�p���āA�����I��Stream��Ԃ��܂��B
	 * @return (��)
	 */
	default Stream<E> stream(){
		return null;
	}
	
	/**
	 * ���̃R���N�V�����̗v�f�����ׂĊi�[����Ă���z���Ԃ��܂��B
	 * @return
	 */
	Object[] toArray();

	/**
	 * ���̃R���N�V�������̂��ׂĂ̗v�f��ێ�����z���Ԃ��܂��B�Ԃ����z��̎��s���̌^�́A�w�肳�ꂽ�z��̌^�ł��B
	 * @param a
	 * @return
	 */
	<T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException;


}