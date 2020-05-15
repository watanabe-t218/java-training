package interpret;

public class TestClass {
	public String strPublic;
	private String strPrivate;
	private int intPrivate;
	private TestClass testClass;
	private int[] intArray;

	final private String strPrivateFinal;
	static final private String strPrivateFinalStatic = "defaultStrPrivateFinalStatic";
	
	public TestClass() {
		this.strPublic = "defaultStrPublic";
		this.strPrivate = "defaultStrPrivate";
		this.strPrivateFinal = "defaultStrPrivateFinal";
	}

	public TestClass(String strPublic, String strPrivate) {
		this.strPublic = strPublic;
		this.strPrivate = strPrivate;
		this.strPrivateFinal = "strPrivateFinal";
	}
	
	public TestClass(String strPublic, String strPrivate, int intPrivate) {
		this.strPublic = strPublic;
		this.strPrivate = strPrivate;
		this.strPrivateFinal = "strPrivateFinal";
		this.intPrivate = intPrivate;
	}
	
	public TestClass(String strPublic, TestClass testClass) {
		this.strPublic = strPublic;
		this.strPrivateFinal = "strPrivateFinal";
		this.testClass = testClass;
	}
	
	public TestClass(String strPublic, int[] intArray) {
		this.strPublic = strPublic;
		this.strPrivateFinal = "strPrivateFinal";
		this.intArray = intArray;
	}

	public int SumIntAndTestClass() {
		this.intPrivate += this.testClass.intPrivate;
		return this.intPrivate;
	}
	

	public String getStrPrivateFinal() {
		return strPrivateFinal;
	}

	public static String getStrprivatefinalstatic() {
		return strPrivateFinalStatic;
	}

	public String getStrPrivate() {
		return strPrivate;
	}

	public void setStrPrivate(String strPrivate) {
		this.strPrivate = strPrivate;
	}

	public int getIntPrivate() {
		return intPrivate;
	}

	public void setIntPrivate(int intPrivate) {
		this.intPrivate = intPrivate;
	}
	
   
	
}
