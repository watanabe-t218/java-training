/**
 * 
 */
package ex05;

/**
 * @author watanabe
 *
 */
public class MoneyFormatConvert {
	final static int splitSize = 3;
	
	public String makeMoneyFormat(String str) {
		String moneyFormatStr = "";
		
		char[] buff = str.toCharArray();
		int charCount = 0;
		for(int i = buff.length - 1; i >= 0; i--) {
			moneyFormatStr = buff[i] + moneyFormatStr;
			charCount++;
			
			if(charCount == splitSize) {
				moneyFormatStr = "," + moneyFormatStr;
				charCount = 0;
			}		
		}
		if(moneyFormatStr.indexOf(",") == 0) {
			moneyFormatStr = moneyFormatStr.substring(1);
		}
		
		return moneyFormatStr;
	}
	
}
