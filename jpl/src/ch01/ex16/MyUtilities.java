package ex16;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author takahiro watanabe
 *
 */
public class MyUtilities {
	public double[] getDataSet(String setName)
			throws BadDataSetException 
	{
		
		String file =  setName + ".dest";
		FileInputStream in = null;
		
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException(file, e);
		} finally {		
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				; 	// Ignore:	Data read has been success 
				  	// 			OR throw BadDataSetException
			}
		}
	}
	
	public double[] readDataSet(FileInputStream in) {
		double[] data = {1, 1, 1, 1};
		return data;
	}
}
