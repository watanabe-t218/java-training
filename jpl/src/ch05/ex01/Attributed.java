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

	// [x]  Attrデータの作成に，add()等の実装を行う必要があり，メリットがないように思われる．
	// データを保持するAttr,　必要であれば操作を担うAttributedとその実装クラスを用いる，という想定で
	// ネストの必要はないのではないかと考えられる
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