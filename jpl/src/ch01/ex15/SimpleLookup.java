package ex15;

/**
 * @author takahiro watanabe
 *
 */
public class SimpleLookup implements ImprovedLookup<Object>{
	static final int MAX_INDEX = 100;	
	private String[] names;
	private Object[] values;
	
	public SimpleLookup() {
		this.names = new String[MAX_INDEX];
		this.values = new Object[MAX_INDEX];
	}
	
	@Override
	public Object find(String name) {
		for(int i = 0; i < this.names.length; i++) {
			if(this.names[i] != null && this.names[i].equals(name)) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	public void add(String name, Object value) {
		for(int i = 0; i < this.names.length; i++) {
			if(names[i] == null) {
				this.names[i] = name;
				this.values[i] = value;
				return;
			}
		}
	}

	@Override
	public Object remove(Object name) {
		for(int i = 0; i < this.names.length; i++) {
			if(this.names[i].equals(name)) {
				names[i] = null;
				values[i] = null;
				return i;
			}
		}	
		return null;
	}
	
}
