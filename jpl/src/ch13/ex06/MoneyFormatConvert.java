/**
 * 
 */
package ex06;

/**
 * @author watanabe
 *
 */
public class MoneyFormatConvert {
	
	public String makeMoneyFormat(String str, int splitSize, char splitChar) {
		String moneyFormatStr = "";
		
		char[] buff = str.toCharArray();
		int charCount = 0;
		for(int i = buff.length - 1; i >= 0; i--) {
			moneyFormatStr = buff[i] + moneyFormatStr;
			charCount++;
			
			if(charCount == splitSize) {
				moneyFormatStr = splitChar + moneyFormatStr;
				charCount = 0;
			}		
		}
		if(moneyFormatStr.indexOf(splitChar) == 0) {
			moneyFormatStr = moneyFormatStr.substring(1);
		}
		
		return moneyFormatStr;
	}
	
}
