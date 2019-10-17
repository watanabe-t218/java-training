/**
 * 
 */
package ex05;

/**
 * @author Watari-Home
 *
 */
public enum EnumTrafficLight {
	
	// �ŗL�̃��\�b�h�ŏ������ς��킯�ł͂Ȃ��̂ŁC��������Ȃ��̂ł͂Ȃ���
	// �������C�M���Ɋւ��Č����΁C�M���̓_����ԓ����o�͂���\��������C�ʂŎ����Ƃ��l�����邪�C
	// ����̏ꍇ�C���ʂ̃��\�b�h���Ŋ������Ă��ς��Ȃ��̂ł͂Ȃ����D
	
	RED (new Color("red")) {
		public Color getColor() {
			return color;
		}
	},
	Yellow (new Color("yellow")) {
		public Color getColor() {
			return color;
		}
	},
	Blue (new Color("blue")) {
		public Color getColor() {
			return color;
		}
	};
	
	Color color;
	EnumTrafficLight(Color color) {
		this.color = color;
	}
	
	public String toString( ) {
		return color.getColorName();
	}
	
	abstract public Color getColor();
}