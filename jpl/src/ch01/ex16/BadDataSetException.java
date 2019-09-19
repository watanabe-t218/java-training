package ex16;

import java.io.IOException;

/**
 * @author takahiro watanabe
 * 
 */
public class BadDataSetException extends Exception{
	private String fileName;
	
	// reference: https://www.atmarkit.co.jp/ait/articles/0605/27/news020.html
	public BadDataSetException(String fileName, IOException e) {
		super(e);
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
}
