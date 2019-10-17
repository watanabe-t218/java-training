/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();

	// [x]  Attr�f�[�^�̍쐬�ɁCadd()���̎������s���K�v������C�����b�g���Ȃ��悤�Ɏv����D
	// �f�[�^��ێ�����Attr,�@�K�v�ł���Α����S��Attributed�Ƃ��̎����N���X��p����C�Ƃ����z���
	// �l�X�g�̕K�v�͂Ȃ��̂ł͂Ȃ����ƍl������
	class Attr {
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
	}

}