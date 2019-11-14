/**
 * 
 */
package ex05;

/**
 * @author takahiro watanabe
 *
 */
public class BetweenChars {


	public static String betweenChars(char from, char to) {
		if((int)from < 0x61 || (int)from > 0x87 || (int)to > 0x87 || (int)to < 0x61) {
			return "Please input lowercase alphabet\n";
		}
		String fromString = String.valueOf(from);
		String toString = String.valueOf(to);
		if(fromString.compareTo(toString) > 0) {
			return "No Chars between [" + from + "] and [" + to + "]\n";
		}
		
		String result = "";
		for(char tempChar = from; tempChar <= to; tempChar++) {
			result += tempChar;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(betweenChars('b', 'h'));
	}

}
