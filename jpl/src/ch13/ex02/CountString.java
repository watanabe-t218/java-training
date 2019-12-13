/**
 * 
 */
package ex02;

/**
 * @author watanabe
 *
 */
public class CountString {
	public static int countString(String originalStr, String searchStr) {
		int count = 0;
		int index = originalStr.indexOf(searchStr);
		
		while(index != -1) {
			index = originalStr.indexOf(searchStr, index+1);
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		String str1 = "aaaaaaa";
		System.out.println(countString(str1, "aa"));
		
		String str2 = "abcdefg/abcdefg/abcdefg/ab";
		System.out.println(countString(str2, "ab"));
	}
}
