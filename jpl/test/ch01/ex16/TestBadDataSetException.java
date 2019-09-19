package ex16;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class TestBadDataSetException {

	@Test
	void testBadDataSetException() throws BadDataSetException {
		String file =  "Test.dest";
		FileInputStream in = null;
		
		try {
			throw new IOException();
		} catch (IOException e) {
			try {
				throw new BadDataSetException(file, e);
			} catch (BadDataSetException ee) {
				assertEquals(file, ee.getFileName());
			}
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
}
