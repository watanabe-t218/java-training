package interpret;

public class TestClass {
	public String strPublic;
	private String strPrivate;
	public String getStrPrivateFinal() {
		return strPrivateFinal;
	}

	public static String getStrprivatefinalstatic() {
		return strPrivateFinalStatic;
	}

	final private String strPrivateFinal;
	static final private String strPrivateFinalStatic = "defaultStrPrivateFinalStatic";
	

	public TestClass(String strPublic, String strPrivate) {
		this.strPublic = strPublic;
		this.strPrivate = strPrivate;
		this.strPrivateFinal = "strPrivateFinal";
	}
	
	public TestClass() {
		this.strPublic = "defaultStrPublic";
		this.strPrivate = "defaultStrPrivate";
		this.strPrivateFinal = "defaultStrPrivateFinal";
	}

	public String getStrPrivate() {
		return strPrivate;
	}

	public void setStrPrivate(String strPrivate) {
		this.strPrivate = strPrivate;
	}
	
}
