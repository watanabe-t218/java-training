/**
 * 
 */
package ex07;

/**
 * @author takahiro watanabe
 *
 */
/**
 * @author Watari-Home
 *
 */
public class ColorAttr extends Attr {
	private ScreenColor myColor;

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	public Object setValue(Object newValue) {
		// スーパークラスのsetValueを最初に行う
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	// 値を記述ではなく，ScreenColorに設定する
	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	// 変換されたScreenColorオブジェクトを返す
	public ScreenColor getColor() {
		return myColor;
	}

	// getValueで得られる記述からScreenColorを設定する
	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

	
	/**
	 * Compare myColor & obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (myColor.toString() == ((ColorAttr)obj).getColor().toString()) {
			return true;			
		} else {
			return false;			
		}
	}

	/**
	 * get hashcode from myColor string
	 */
	@Override
	public int hashCode() {
		return myColor.toString().hashCode();
	}

	public static void main(String[] args) {
		ColorAttr ca1 = new ColorAttr("red");
		ColorAttr ca2 = new ColorAttr("green");
		System.out.println(ca1.equals(ca2));
		System.out.println("red: " + ca1.hashCode() + ", greeen: " + ca2.hashCode());
	}
}
