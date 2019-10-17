/**
 * 
 */
package ex05;

/**
 * @author Watari-Home
 *
 */
public enum EnumTrafficLight {
	
	// 固有のメソッドで処理が変わるわけではないので，推奨されないのではないか
	// ただし，信号に関して言えば，信号の点灯状態等も出力する可能性があり，個別で持つことも考えられるが，
	// 今回の場合，共通のメソッド内で完結しても変わらないのではないか．
	
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