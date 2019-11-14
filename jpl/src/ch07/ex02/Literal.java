/**
 * 
 */
package ex02;

/**
 * @author takahiro watanabe
 *
 */
public class Literal {

	boolean booleanTest = false; 			// 1bit
	byte byteTest = 127;					// 8bit
	char charTest = 'a';					// 16bit
	short shortTest = 32767;				// 16bit
	int intTest = 2147483647;				// 32bit
	long longTest = 9223372036854775807L;	// 64bit
	float floatTest = 100.0f;				// 32bit
	double doubleTest = 100.0d;  			// 64bit
	
	public void setDefault() {
		booleanTest = false; 		
		byteTest = 127;				
		charTest = 'a';				
		shortTest = 32767;				
		intTest = 2147483647;				
		longTest = 9223372036854775807L;
		floatTest = 100.0f;			
		doubleTest = 100.0d;  	
	}
	
	public static void main(String[] args) {
		
		Literal literal = new Literal();
		
		//short <- int (incorrect number)
		literal.setDefault();
		literal.shortTest = (short)literal.intTest;
		System.out.printf("short <- int: %d%n", literal.shortTest);
		
		//int <- byte
		literal.setDefault();
		literal.intTest = literal.byteTest;
		System.out.printf("int <- byte: %d%n", literal.intTest);

		//int <- short 
		literal.setDefault();
		literal.intTest = literal.shortTest;
		System.out.printf("int <- short: %d%n", literal.shortTest);

		//int <- char
		literal.setDefault();
		literal.intTest = (int)literal.charTest;
		System.out.printf("int <- char: %d%n", literal.intTest);
		
		//int <- long (incorrect number)
		literal.setDefault();
		literal.intTest = (int)literal.longTest;
		System.out.printf("int <- long: %d%n", literal.intTest);
		
		//float <- double 
		literal.setDefault();
		literal.floatTest = (float)923456789.23456789d;
		System.out.println("float <- double: " + literal.floatTest);

		//double <- float (not equal number)
		literal.setDefault();
		literal.doubleTest = 1.23456789f;
		System.out.println("double <- float: " + literal.doubleTest);
		
		//double <- long (incorrect number)
		literal.setDefault();
		literal.doubleTest = (double)literal.longTest;
		System.out.println("double <- long: " + literal.doubleTest);
	}

}
