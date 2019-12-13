package ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDelimitedString {

	@Test
	void test() {
		DelimitedString dl = new DelimitedString();
		
		String from = "[a[b[c]d]e]";
		
		String outputStr = "";
		String expectedStr = ""
				+ "[a[b[c]d]e]\n"
				+ "[a[b[c]d]\n"
				+ "[a[b[c]\n"
				+ "[b[c]d]e]\n"
				+ "[b[c]d]\n"
				+ "[b[c]\n[c]d]e]\n" 
				+ "[c]d]\n"
				+ "[c]\n";
		
		for(String str: dl.delimitedString(from, '[', ']')) {
			outputStr += str + "\n";
		}
		
		assertEquals(expectedStr, outputStr);
	}

}
