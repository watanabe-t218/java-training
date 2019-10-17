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

	// [x] Attrクラスの操作をするインターフェースであるから．ネストしても良いように思われるが，
	// Attr.Attributedクラスの実装クラスを用意する必要があり，結局手間が増えてメリットがないように思われる．
	// データを保持するAttr,　必要であれば操作を担うAttributedとその実装クラスを用いる，という想定で
	// ネストの必要はないのではないかと考えられる
	public interface Attributed {
		void add(Attr newAttr);
		Attr find(String attrName);
		Attr remove(String attrName);
		java.util.Iterator<Attr> attrs();
	}
}