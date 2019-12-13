/**
 * 
 */
package ex01;

/**
 * @author watanabe
 *
 */
public class CountChar {
	public static int countCharAtString(String searchString, char serchChar) {
		int count = 0;
		
		for (int i = 0; i < searchString.length(); i++) {
		    if (searchString.charAt(i) == serchChar) {
		        count++;
		    }
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str1 = "aaaaaaa";
		System.out.println(countCharAtString(str1, 'a'));
		
		String str2 = "abcdefg/abcdefg/abcdefg";
		System.out.println(countCharAtString(str2, 'a'));
	}
}
