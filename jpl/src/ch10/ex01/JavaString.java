/**
 * 
 */
package ex01;

/**
 * @author Watari-Home
 *
 */
public class JavaString {

	public static String charEncode(char c) {
		String result = "";
		if (c == '\n')
			result += "\\n";
		else if (c == '\t')
			result += "\\t";
		else if (c == '\b')
			result += "\\b";
		else if (c == '\r')
			result += "\\r";
		else if (c == '\\')
			result += "\\\\";
		else if (c == '\'')
			result += "\\\'";
		else if (c == '\"')
			result += "\\\"";
		else
			result += c;
		
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
