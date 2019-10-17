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
	 * �w�肳�ꂽ�v�f�����̃R���N�V�����Ɋi�[����Ă��邱�Ƃ�ۏ؂��܂�(�I�v�V�����̑���)�B
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
	 * �w�肳�ꂽ�R���N�V�����̂��ׂĂ̗v�f�����̃R���N�V�����ɒǉ����܂�(�I�v�V�����̑���)�B
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
	 * ���̃R���N�V�������炷�ׂĂ̗v�f���폜���܂�(�I�v�V�����̑���)�B
	 */
	@Override
	void clear() throws UnsupportedOperationException;

	/**
	 * �w�肳�ꂽ�v�f���R���N�V�����Ɋ܂܂�Ă���ꍇ��true��Ԃ��܂��B
	 * @param o
	 * @return
	 */
	@Override
	boolean contains(Object o) throws ClassCastException, NullPointerException;

	/**
	 * �w�肳�ꂽ�R���N�V�����̂��ׂĂ̗v�f�����̃R���N�V�������ɂ���ꍇ��true��Ԃ��܂��B
	 * @param c
	 * @return
	 */
	@Override
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
	@Override
	boolean isEmpty();

	/**
	 * �R���N�V�����̗v�f�̃C�e���[�^��Ԃ��܂��B
	 * @return
	 */
	@Override
	Iterator<E> iterator();

	/**
	 * �w�肳�ꂽ�v�f�̃C���X�^���X�����̃R���N�V�����ɂ���΁A���̃C���X�^���X���R���N�V��������1�폜���܂�(�I�v�V�����̑���)�B
	 * @param o
	 * @return
	 */
	@Override
	boolean remove(Object o)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * �w�肳�ꂽ�R���N�V�����ɂ��i�[����Ă��邱�̃R���N�V�����̂��ׂĂ̗v�f���폜���܂�(�I�v�V�����̑���)�B
	 * @param c
	 * @return
	 */
	@Override
	boolean removeAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * ���̃R���N�V�����ɂ����āA�w�肳�ꂽ�R���N�V�����Ɋi�[����Ă���v�f������ێ����܂�(�I�v�V�����̑���)�B
	 * @param c
	 * @return
	 */
	@Override
	boolean retainAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;


	/**
	 * ���̃R���N�V�������̗v�f�̐���Ԃ��܂��B
	 * @return
	 */
	@Override
	int size();

	/**
	 * ���̃R���N�V�����̗v�f�����ׂĊi�[����Ă���z���Ԃ��܂��B
	 * @return
	 */
	@Override
	Object[] toArray();

	/**
	 * ���̃R���N�V�������̂��ׂĂ̗v�f��ێ�����z���Ԃ��܂��B�Ԃ����z��̎��s���̌^�́A�w�肳�ꂽ�z��̌^�ł��B
	 * @param a
	 * @return
	 */
	@Override
	<T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException;
}
