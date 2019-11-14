/**
 * 
 */
package ex02;

/**
 * @author Watari-Home
 *
 */
public class JavaString {

	public static String charEncode(char c) {
		String result = "";
		
		switch (c) {
		case '\n':
			result += "\\n";
			break;
		case '\t':
			result += "\\t";
			break;
		case '\b':
			result += "\\b";
			break;
		case '\r':
			result += "\\r";
			break;
		case '\\':
			result += "\\\\";
			break;
		case '\'':
			result += "\\'";
			break;
		case '\"':
			result += "\\\"";
			break;
		default:
			result += c;
			break;
		}
		
		return result;
	}
	
	public static String stringEncode(String s) {
		String result = "";
		for (char c: s.toCharArray()) {
			result += charEncode(c);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String before = "aaa\naaa\taaa\baaa\raaa\\aaa\'aaa\"aaa";
		System.out.println("[Before]:" + before);
		String after = stringEncode(before);
		System.out.println("[After]:" + after);
	}

}
