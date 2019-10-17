/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		return oldValue;
	}

	public String toString() {
		return name + "='" + value + "'";
	}

	// [x] Attr�N���X�̑��������C���^�[�t�F�[�X�ł��邩��D�l�X�g���Ă��ǂ��悤�Ɏv���邪�C
	// Attr.Attributed�N���X�̎����N���X��p�ӂ���K�v������C���ǎ�Ԃ������ă����b�g���Ȃ��悤�Ɏv����D
	// �f�[�^��ێ�����Attr,�@�K�v�ł���Α����S��Attributed�Ƃ��̎����N���X��p����C�Ƃ����z���
	// �l�X�g�̕K�v�͂Ȃ��̂ł͂Ȃ����ƍl������
	public interface Attributed {
		void add(Attr newAttr);
		Attr find(String attrName);
		Attr remove(String attrName);
		java.util.Iterator<Attr> attrs();
	}
}